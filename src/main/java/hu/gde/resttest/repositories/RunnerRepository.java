package hu.gde.resttest.repositories;

import hu.gde.resttest.model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Integer> {
    Runner findByName(String runnerName);
}
