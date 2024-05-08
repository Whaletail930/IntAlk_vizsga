package hu.gde.resttest;

import hu.gde.resttest.repositories.RaceRepository;
import hu.gde.resttest.repositories.ResultRepository;
import hu.gde.resttest.repositories.RunnerRepository;
import hu.gde.resttest.model.Race;
import hu.gde.resttest.model.Result;
import hu.gde.resttest.model.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
@Component
public class ResttestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ResttestApplication.class, args);
	}

	@Autowired
	private RunnerRepository runnerRepository;
	@Autowired
	private RaceRepository raceRepository;
	@Autowired
	private ResultRepository resultRepository;

	@Override
	public void run(String... args) throws Exception {
		Runner runner1 = new Runner("Gergely Kovács", "male", 28);
		Runner runner2 = new Runner("Emese Tóth", "female", 22);
		Runner runner3 = new Runner("Bálint Varga", "male", 31);
		Runner runner4 = new Runner("Anikó Szabó", "female", 20);
		Runner runner5 = new Runner("Ferenc Kiss", "male", 26);
		Runner runner6 = new Runner("Réka Horváth", "female", 24);
		Runner runner7 = new Runner("Máté Papp", "male", 29);
		Runner runner8 = new Runner("Dóra Kovács", "female", 21);
		Runner runner9 = new Runner("Tamás Mészáros", "male", 35);
		Runner runner10 = new Runner("Szilvia Nagy", "female", 30);
		Runner runner11 = new Runner("Zoltán Farkas", "male", 27);
		Runner runner12 = new Runner("Katalin Balázs", "female", 23);
		Runner runner13 = new Runner("Attila Török", "male", 32);
		Runner runner14 = new Runner("Eszter Kovács", "female", 25);
		Runner runner15 = new Runner("Miklós Szabó", "male", 33);


		Race race1= new Race("Race1",10);
		Race race2= new Race("Race2",5);
		Race race3= new Race("Race3",15);
		Race race4= new Race("Race4",20);
		Race race5= new Race("Race5",17);
		Race race6= new Race("Race6",30);
		Race race7= new Race("Race7",5);
		Race race8= new Race("Race8",12);
		Race race9= new Race("Race9",23);
		Race race10= new Race("Race10",11);

		Result result1 = new Result(runner1, race2, 50);
		Result result2 = new Result(runner1, race1, 30);
		Result result3 = new Result(runner3, race1, 54);
		Result result4 = new Result(runner2, race2, 23);
		Result result5 = new Result(runner3, race2, 42);
		Result result6 = new Result(runner6, race10, 59);
		Result result7 = new Result(runner3, race3, 21);
		Result result8 = new Result(runner7, race3, 32);
		Result result9 = new Result(runner8, race10, 43);
		Result result10 = new Result(runner5, race4, 54);
		Result result11 = new Result(runner6, race5, 122);
		Result result12 = new Result(runner6, race5, 231);
		Result result13 = new Result(runner5, race3, 231);
		Result result14 = new Result(runner7, race4, 23);
		Result result15 = new Result(runner8, race5, 45);
		Result result16 = new Result(runner9, race6, 32);
		Result result17 = new Result(runner10, race2, 66);
		Result result18 = new Result(runner11, race9, 76);
		Result result19 = new Result(runner12, race4, 87);
		Result result20 = new Result(runner13, race9, 43);
		Result result21 = new Result(runner14, race1, 54);
		Result result22 = new Result(runner15, race2, 76);
		Result result23 = new Result(runner1, race3, 98);
		Result result24 = new Result(runner3, race7, 31);
		Result result25 = new Result(runner3, race5, 65);
		Result result26 = new Result(runner4, race1, 76);
		Result result27 = new Result(runner5, race2, 87);
		Result result28 = new Result(runner6, race3, 43);
		Result result29 = new Result(runner7, race8, 54);
		Result result30 = new Result(runner8, race8, 65);


		runnerRepository.saveAll(Arrays.asList(runner1, runner2, runner3, runner4, runner5, runner6, runner7, runner8, runner9, runner10, runner11, runner12, runner13, runner14, runner15));
		raceRepository.saveAll(Arrays.asList(race1, race2, race3, race4, race5, race6, race7, race8, race9, race10));
		resultRepository.saveAll(Arrays.asList(result1, result2, result3, result4, result5, result6, result7, result8, result9, result10, result11, result12, result13, result14, result15, result16, result17, result18, result19, result20, result21, result22, result23, result24, result25, result26, result27, result28, result29, result30));

	}

}
