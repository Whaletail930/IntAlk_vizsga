package hu.gde.resttest.controller;

import hu.gde.resttest.model.Race;
import hu.gde.resttest.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/race")
public class RaceController {

    @Autowired
    private RaceService raceService;


    @GetMapping("/getRace")
    public ModelAndView getAllRace(){
        return raceService.allRace();
    }

    @PostMapping("/updateRace")
    public ResponseEntity<String> updateRace(@RequestBody Map<String, Object> payload) {
        if (!payload.containsKey("id") || !payload.containsKey("raceName") || !payload.containsKey("distance")) {
            return ResponseEntity.badRequest().body("Missing required fields");
        }

        Integer id = (Integer) payload.get("id");
        String raceName = (String) payload.get("raceName");
        Integer distance = (Integer) payload.get("distance");

        Optional<Race> updatedRace = raceService.getupdateRace(id, raceName, distance);
        if (updatedRace.isPresent()) {
            return ResponseEntity.ok("Race updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
