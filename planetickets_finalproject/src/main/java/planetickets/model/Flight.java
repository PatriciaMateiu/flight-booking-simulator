package planetickets.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flightNr;
	@Column
	private String srcAirport;
	@Column
	private String destAirport;
	@Column
	private String company;
	@Column
	private Date date;
	@Column
	private Integer duration;
	@Column
	private Integer price;
	// private Company company;
	@Transient
	private List<User> passengers;

	// @ManyToMany(fetch = FetchType.LAZY)

	// @Transient
	// private Set<Integer> users = new HashSet<>();
	@Column
	private String users;
	

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(Integer flightNr, String srcAirport, String destAirport, String company, Date date, Integer duration,
			Integer price, String users) {
		super();
		this.flightNr = flightNr;
		this.srcAirport = srcAirport;
		this.destAirport = destAirport;
		this.company = company;
		this.date = date;
		this.duration = duration;
		this.price = price;
		this.users = users;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getFlightNr() {
		return flightNr;
	}

	public void setFlightNr(Integer flightNr) {
		this.flightNr = flightNr;
	}

	public String getSrcAirport() {
		return srcAirport;
	}

	public void setSrcAirport(String src_airport) {
		this.srcAirport = src_airport;
	}

	public String getDestAirport() {
		return destAirport;
	}

	public void setDestAirport(String dest_airport) {
		this.destAirport = dest_airport;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	/*
	 * public Company getCompany() { return company; }
	 * 
	 * public void setCompany(Company company) { this.company = company; }
	 */

	public List<User> getPassengers() {
		return passengers;
	}

	public void addPassenger(User passenger) {
		passengers.add(passenger);
	}

	public void map(Flight flight) {
		if (flight.flightNr != null) {
			this.flightNr = flight.flightNr;
		}
		if (flight.srcAirport != null && flight.srcAirport != "") {
			this.srcAirport = flight.srcAirport;
		}
		if (flight.destAirport != null && flight.destAirport != "") {
			this.destAirport = flight.destAirport;
		}
		if (flight.company != null && flight.company != "") {
			this.company = flight.company;
		}
		if (flight.date != null) {
			this.date = flight.date;
		}
		if (flight.duration != null && flight.duration != 0) {
			this.duration = flight.duration;
		}
		if (flight.price != null && flight.price != 0) {
			this.price = flight.price;
		}
		if (flight.users != null && flight.users != "") {
			this.users = flight.users;
		}
	}

	/*public List<String> individualusers() {

		char dl = ' ';
		String word = "";
		String str = this.users + dl;
		int l = str.length();

		List<String> substr_list = new ArrayList<String>();
		for (int i = 0; i < l; i++) {

			if (users.charAt(i) != dl) {
				word = word + str.charAt(i);
			} else {
				if ((int) word.length() != 0) {
					substr_list.add(word);
				}

				word = "";
			}
		}
		return substr_list;
	}*/
}
