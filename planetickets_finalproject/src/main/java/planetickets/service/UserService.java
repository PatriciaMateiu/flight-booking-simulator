package planetickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import planetickets.model.User;
import planetickets.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository urep;
	
	public User create(User user) {
		return urep.save(user);
	}

	public List<User> listAll() {
		return urep.findAll();
	}

	public void save(User user) {
		urep.save(user);
	}

	public User get(Integer id) {
		return urep.findById(id).get();
	}

	public void delete(Integer id) {
		urep.deleteById(id);
	}

}
