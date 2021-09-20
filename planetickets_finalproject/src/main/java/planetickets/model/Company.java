package planetickets.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@Column
	private Integer nrEmployees;
	@Column
	private String pricing;
	@OneToMany
	private List<User> employees;
	@OneToMany
	private List<Flight> flights;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Integer getNr_employees() {
		return nrEmployees;
	}

	public void setNrEmployees(Integer nrEmployees) {
		this.nrEmployees = nrEmployees;
	}

	public void increaseNrEmployees(int amount) {
		setNrEmployees(nrEmployees + amount);
	}

	public void decreaseNrEmployees(int amount) {
		setNrEmployees(nrEmployees - amount);
	}

	public String getPricing() {
		return pricing;
	}

	public void setPricing(String pricing) {
		this.pricing = pricing;
	}

	public List<User> getEmployees() {
		return employees;
	}

	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}

	public Integer getNrEmployees() {
		return nrEmployees;
	}

	public List<Flight> getFlights() {
		return flights;
	}

}
