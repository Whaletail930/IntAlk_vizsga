package hu.gde.resttest.service;

import hu.gde.resttest.repositories.RunnerRepository;
import hu.gde.resttest.model.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnerService {

@Autowired
    private RunnerRepository runnerRepository;
    public List<Runner> allRunner(){
        return runnerRepository.findAll();
    }
   public Runner createRunner(String name,String gender, Integer age){

       Runner runner = new Runner();
       runner.setName(name);
       runner.setGender(gender);
       runner.setAge(age);

       return runnerRepository.save(runner);
   }
}
