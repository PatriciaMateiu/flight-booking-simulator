package planetickets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import planetickets.model.ERole;
import planetickets.model.Flight;
import planetickets.model.Role;

public interface FlightRepository extends JpaRepository<Flight, Integer> {


}
