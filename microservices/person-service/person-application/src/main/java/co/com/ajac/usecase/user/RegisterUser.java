package co.com.ajac.usecase.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.exceptions.NotSaveModelException;
import co.com.ajac.models.User;
import co.com.ajac.services.user.UserService;
import common.usecases.Query;


@Component
public class RegisterUser implements Query <User, User>{
	
	private static final String UNREGISTERED_USER = "¡Ouups! El usuario no pudo ser registrado";
	private final UserService userService;

	@Autowired
	public RegisterUser(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User execute( User user ) {
		return userService.registerUser(user)
				.orElseThrow(() -> new NotSaveModelException(UNREGISTERED_USER));
	}
}
