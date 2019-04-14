package co.com.ajac.database.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.UserRepository;
import co.com.ajac.models.User;
import co.com.ajac.ports.IUserRepository;

@Component
public class UserRepositoryAdapter implements IUserRepository{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> save(User user) {
		return userRepository.create(user);
	}

	@Override
	public Optional<User> login(String username, String password) {
		return userRepository.login(username, password);
	}

	@Override
	public Optional<User> get(String identification) {
		return userRepository.get(identification);
	}

	@Override
	public Optional<List<User>> getAll() {
		return userRepository.findUserActives();
	}

}
