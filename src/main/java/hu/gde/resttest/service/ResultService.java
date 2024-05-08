package hu.gde.resttest.service;

import hu.gde.resttest.repositories.RaceRepository;
import hu.gde.resttest.repositories.ResultRepository;
import hu.gde.resttest.repositories.RunnerRepository;
import hu.gde.resttest.model.Race;
import hu.gde.resttest.model.Result;
import hu.gde.resttest.model.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private RunnerRepository runnerRepository;
    public List<Result> allResult()
    {

        return resultRepository.findAll();
    }
    public List<Object[]> raceStats(Integer raceId){
    return resultRepository.findResultByRaceId(raceId);
    }
    public Result addResult(String runnerName,String raceName,Integer time){
        Runner runner= runnerRepository.findByName(runnerName);
        Race race= raceRepository.findRaceByRaceName(raceName);
        if (race!= null && runner!= null){
            Result result= new Result(runner,race,time);
             return resultRepository.save(result);
        }
        else {
            throw new RuntimeException("Hibás futónév");
        }
    }
    public Optional<Double> averageTime(Integer raceId){
        return resultRepository.findAverageTimeByRaceId(raceId);
    }
}
