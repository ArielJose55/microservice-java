package co.com.ajac.services.user;

import java.util.List;
import java.util.Optional;

import co.com.ajac.models.User;
import co.com.ajac.ports.UserRepository;
import domain.exceptions.ModelNotFoundException;


public class UserService {
	
	private static final String INCORRECT_CREDENTIALS = "Nombre de usuario o contraseña son incorrectas";

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Optional<User> registerUser(User user){
		
		return userRepository.save(user);
	}
	
	public User login(String username, String password){
		
		User user = userRepository.login(username, password)
				.orElseThrow(() -> new ModelNotFoundException(INCORRECT_CREDENTIALS));
		
		if(user.getState().equals("INACTIVE"))
			throw new ModelNotFoundException("Usuario inactivo. Por favor, Consulte al administrador");
			
		return user;
	}
	
	public Optional<User> findOneBy(String identification){
		return userRepository.get(identification);
	}
	
	public Optional<List<User>> findAll(){
		return userRepository.getAll();
	}
}
