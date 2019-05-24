package co.com.ajac.ports;

import java.util.List;
import java.util.Optional;

import co.com.ajac.models.User;

public interface UserRepository {

	public Optional<User> save(User user);
	
	public Optional<User> login(String username, String password);
	
	public Optional<User> get(String identification);
	
	public Optional<List<User>> getAll();
	
	
}
