package planetickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import planetickets.model.Flight;
import planetickets.repository.FlightRepository;

@Service
public class FlightService {

	
	@Autowired
	private FlightRepository frep;
	
	public Flight create(Flight flight) {
		return frep.save(flight);
	}

	public List<Flight> listAll() {
		return frep.findAll();
	}

	public void save(Flight flight) {
		frep.save(flight);
	}

	public Flight get(Integer id) {
		return frep.findById(id).get();
	}

	public void delete(Integer id) {
		frep.deleteById(id);
	}

}
