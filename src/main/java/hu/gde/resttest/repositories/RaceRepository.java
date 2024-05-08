package hu.gde.resttest.repositories;

import hu.gde.resttest.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {
    Optional<Race> findById(Integer id);
    Race findRaceByRaceName(String raceName);
}
