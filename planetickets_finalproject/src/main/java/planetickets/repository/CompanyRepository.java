package planetickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import planetickets.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
