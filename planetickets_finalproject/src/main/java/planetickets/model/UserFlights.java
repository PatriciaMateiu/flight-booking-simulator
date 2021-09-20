package planetickets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "user_flights")
public class UserFlights {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flight_flight_nr;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getFlight_flight_nr() {
		return flight_flight_nr;
	}

	public void setFlight_flight_nr(Integer flight_flight_nr) {
		this.flight_flight_nr = flight_flight_nr;
	}

	public UserFlights(Integer user_id, Integer flight_flight_nr) {
		super();
		this.user_id = user_id;
		this.flight_flight_nr = flight_flight_nr;
	}
	
	
	
}
