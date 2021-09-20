package planetickets.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String title;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private Date birthDate;
	@Column
	private String country;
	@Column
	private String region;
	@Column
	private String city;
	@Column
	private String address;
	@Column
	private String email;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String phoneNr;
	@Column
	private Integer discountPoints;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_flights", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "flight_flight_nr"))
	private Set<Flight> flights = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(Integer id, String title, String firstName, String lastName, Date birthDate, String country,
			String region, String city, String address, String email, String username, String password, String phoneNr,
			Integer discountPoints, Set<Flight> flights, Set<Role> roles) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.country = country;
		this.region = region;
		this.city = city;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNr = phoneNr;
		this.discountPoints = discountPoints;
		this.flights = flights;
		this.roles = roles;
	}
	


	public User( String email, String username, String password, String title, String firstName, String lastName, Date birthDate, String country, String region,
			String city, String address, String phoneNr, Set<Flight> flights) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.country = country;
		this.region = region;
		this.city = city;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNr = phoneNr;
		this.flights = flights;
	}


	public void map(User user) {
		if (user.title != null) {
			this.title = user.title;
		}
		if (user.firstName != null) {
			this.firstName = user.firstName;
		}
		if (user.lastName != null) {
			this.lastName = user.lastName;
		}
		if (user.birthDate != null) {
			this.birthDate = user.birthDate;
		}
		if (user.country != null) {
			this.country = user.country;
		}
		if (user.region != null) {
			this.region = user.region;
		}
		if (user.city != null) {
			this.city = user.city;
		}
		if (user.address != null) {
			this.address = user.address;
		}
		if (user.email != null) {
			this.email = user.email;
		}
		this.username = user.username;
		if (user.password != null) {
			this.password = user.password;
		}
		if (user.phoneNr != null) {
			this.phoneNr = user.phoneNr;
		}
		if (user.discountPoints != null) {
			this.discountPoints = user.discountPoints;
		}
		if (user.flights != null) {
			this.flights = user.flights;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	

	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public Integer getDiscountPoints() {
		return discountPoints;
	}

	public void setDiscountPoints(Integer discountPoints) {
		this.discountPoints = discountPoints;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
