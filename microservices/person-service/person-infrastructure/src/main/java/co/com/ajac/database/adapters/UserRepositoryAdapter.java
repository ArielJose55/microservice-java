package co.com.ajac.database.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.UserJdbiRepository;
import co.com.ajac.entities.usuarios.Usuario;
import co.com.ajac.ports.UsuarioRepository;

@Component
public class UserRepositoryAdapter implements UsuarioRepository{

	@Autowired
	private UserJdbiRepository userRepository;
	
	@Override
	public Optional<Usuario> save(Usuario user) {
		return userRepository.create(user);
	}

	@Override
	public Optional<Usuario> login(String username, String password) {
		return userRepository.login(username, password);
	}

	@Override
	public Optional<Usuario> get(String identification) {
		return userRepository.get(identification);
	}

	@Override
	public Optional<List<Usuario>> getAll() {
		return userRepository.findUserActives();
	}

}
