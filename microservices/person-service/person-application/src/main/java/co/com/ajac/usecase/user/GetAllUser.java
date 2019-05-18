package co.com.ajac.usecase.user;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import domain.exceptions.ModelNotFoundException;
import co.com.ajac.models.User;
import co.com.ajac.services.user.UserService;
import common.Command;

@Component
public class GetAllUser implements Command<List<User>>{

	private static final String USERS_NOT_FOUND = "¡Ouups! Aún no hay usuarios registrados";
	private final UserService userService;

	@Autowired
	public GetAllUser(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<User> execute() {
		return userService.findAll()
				.orElseThrow(() -> new ModelNotFoundException(USERS_NOT_FOUND));
	}
}
