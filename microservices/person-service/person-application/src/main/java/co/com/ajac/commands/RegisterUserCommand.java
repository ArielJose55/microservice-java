package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.User;
import co.com.ajac.services.user.UserService;
import common.Command;
import domain.exceptions.NotSaveModelException;


@Component
public class RegisterUserCommand implements Command<User>{
	private static final String UNREGISTERED_USER = "¡Ouups! El usuario no pudo ser registrado";
	private final UserService userService;

	@Autowired
	public RegisterUserCommand(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void execute( User user ) {
		userService.registerUser(user)
				.orElseThrow(() -> new NotSaveModelException(UNREGISTERED_USER));
	}
}
