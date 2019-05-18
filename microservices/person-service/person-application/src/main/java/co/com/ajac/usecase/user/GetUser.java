package co.com.ajac.usecase.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.exceptions.ModelNotFoundException;
import co.com.ajac.models.User;
import co.com.ajac.services.user.UserService;
import common.Query;

@Component
public class GetUser implements Query <User, String>{
	
	private static final String USER_NOT_FOUND = "El usuario con esta identificación no existe";
	private final UserService userService;
	
	@Autowired
	public GetUser(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User execute( String identification ) {
		return userService.findOneBy(identification)
				.orElseThrow(() -> new ModelNotFoundException(USER_NOT_FOUND));
	}
}
