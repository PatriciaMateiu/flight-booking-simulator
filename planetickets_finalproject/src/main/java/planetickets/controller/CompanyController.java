package planetickets.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import planetickets.model.Company;
import planetickets.service.CompanyService;

@RestController
public class CompanyController {


	@Autowired
	private CompanyService service;

	@GetMapping("/companies")
	public List<Company> list() {
		return service.listAll();
	}

	@GetMapping("/companies/{id}")
	public ResponseEntity<Company> get(@PathVariable Integer id) {
		try {
			Company company = service.get(id);
			return new ResponseEntity<Company>(company, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/companies")
	public ResponseEntity<?> add(@RequestBody Company company) {
		try {
			service.save(company);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	/*
	 * public void add(@RequestBody User user) { service.save(user); }
	 */

	@PutMapping("/companies/{id}")
	public ResponseEntity<?> update(@RequestBody Company company, @PathVariable Integer id) {
		try {
			Company existCompany = service.get(id);
			service.save(company);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/companies/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
