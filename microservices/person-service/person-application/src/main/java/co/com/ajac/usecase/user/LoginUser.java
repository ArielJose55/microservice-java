package co.com.ajac.usecase.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.exceptions.ModelNotFoundException;
import co.com.ajac.dtos.UserDTO;
import co.com.ajac.models.User;
import co.com.ajac.services.user.UserService;
import common.Query;

@Component
public class LoginUser implements Query < User, UserDTO >{
	
	private static final String INCORRECT_CREDENTIALS = "Nombre de usuario o contraseña son incorrectas";
	private final UserService userService;

	@Autowired
	public LoginUser(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User execute(UserDTO userDTO) {
		
		return userService.login( userDTO.getUsername(), userDTO.getPassword())
				.orElseThrow(() -> new ModelNotFoundException(INCORRECT_CREDENTIALS));
	}
	
}
