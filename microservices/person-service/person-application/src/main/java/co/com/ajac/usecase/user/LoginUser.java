package co.com.ajac.usecase.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.exceptions.ModelNotFoundException;
import domain.exceptions.ViolatedValidationException;
import co.com.ajac.models.User;
import co.com.ajac.services.user.UserService;
import common.Query;

@Component
public class LoginUser implements Query < User, Map<String, String> >{
	
	private static final String INCORRECT_CREDENTIALS = "Nombre de usuario o contraseña son incorrectas";
	private final UserService userService;

	@Autowired
	public LoginUser(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User execute(Map<String, String> query) {
		
		if(query.get("username") == null || query.get("password") == null) {
			throw new ViolatedValidationException("Campos de username y password son requeridos");
		}
		
		return userService.login( query.get("username"), query.get("password"))
				.orElseThrow(() -> new ModelNotFoundException(INCORRECT_CREDENTIALS));
	}
	
}
