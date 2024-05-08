package hu.gde.resttest.controller;

import hu.gde.resttest.model.Result;
import hu.gde.resttest.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/getResult")
    public ResponseEntity<List<Result>> getAllResult(){
        return new  ResponseEntity<List<Result>>(resultService.allResult(),HttpStatus.OK);
    }

    @GetMapping("/getRaceStats/{raceId}")
    public ResponseEntity<List<Object[]>> getRaceRunner(@PathVariable Integer raceId){
        return new ResponseEntity<List<Object[]>>(resultService.raceStats(raceId),HttpStatus.OK);
    }

    @PostMapping("/addResult")
    public ResponseEntity<Result> getAddResult(@RequestBody Map<String,Object> payload){
        String runnerName = (String) payload.get("runnerName");
        String raceName = (String) payload.get("raceName");
        Integer time = (Integer) payload.get("time");

        Result result = resultService.addResult(runnerName, raceName, time);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAverageTime/{raceId}")
    public ResponseEntity<Optional<Double>>getAverageTime(@PathVariable Integer raceId){
        return new ResponseEntity<Optional<Double>>(resultService.averageTime(raceId),HttpStatus.OK);
    }
}
