package planetickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import planetickets.model.Company;
import planetickets.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository crep;
	
	public Company create(Company company) {
		return crep.save(company);
	}

	public List<Company> listAll() {
		return crep.findAll();
	}

	public void save(Company company) {
		crep.save(company);
	}

	public Company get(Integer id) {
		return crep.findById(id).get();
	}

	public void delete(Integer id) {
		crep.deleteById(id);
	}

}
