package planetickets.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import planetickets.MessageDispatcher;
import planetickets.model.Flight;
import planetickets.service.FlightService;
@CrossOrigin(origins= "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/signin")
public class FlightController {

	@Autowired
	private FlightService service;

	@Autowired
	private MessageDispatcher messageDispatcher;
	
	@GetMapping("/flights")
	public List<Flight> list() {
		return service.listAll();
	}

	@GetMapping("/flights/{id}")
	public ResponseEntity<Flight> get(@PathVariable Integer id) {
		try {
			Flight flight = service.get(id);
			return new ResponseEntity<Flight>(flight, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
		}
	}
	


	@PostMapping("/flights")
	public ResponseEntity<?> add(@RequestBody Flight flight) {
		try {
			service.save(flight);
			messageDispatcher.sendToClient("Flight " + flight.getFlightNr() + " from company " + flight.getCompany() + " was added on route " + flight.getSrcAirport() + " - " + flight.getDestAirport());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	/*
	 * public void add(@RequestBody User user) { service.save(user); }
	 */

	@PutMapping("/flights/{id}")
	public ResponseEntity<?> update(@RequestBody Flight flight, @PathVariable Integer id) {
		try {
			Flight existFlight = service.get(id);
			existFlight.map(flight);
			service.save(existFlight);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/flights/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
