package co.com.ajac.models;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import co.com.ajac.coremodel.Person;

public class User extends Person{
	
	private static final String FIELD_NOT_EMPLY = "Este campo no puede estar vacío";

	private static final String CONTRASENA_PATTERN_VALIDATE = "Password debe contener caracteres alfanuméricos (letras y nmeros)";

	private static final String USERNAME_PATTERN_VALIDATE = "Username ";

	private static final String USERNAME_MESSAGE_VALIDATE = "La contraseña debe tener una longitud de entre {min} y {max} caracteres";

	private static final String CONTRASENA_MESSAGE_VALIDATE = "El password debe tener una longitud de entre {min} y {max}  caracteres";

	
	private Integer id;
	
	@NotEmpty(message = FIELD_NOT_EMPLY)
	@Size(min = 5, max = 20, message = USERNAME_MESSAGE_VALIDATE)
	private String username;
	
	@NotEmpty(message = FIELD_NOT_EMPLY)
	@Size(min = 5, max = 20, message = CONTRASENA_MESSAGE_VALIDATE)
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{0,}$", message = CONTRASENA_PATTERN_VALIDATE)
	private String password;
	
	private LocalDateTime registerDate;

	@Future(message = "")
	private LocalDateTime departureDate;
	
	
	
	/**
	 * @param identification
	 * @param typeIdentification
	 */
	public User(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}	
	
	
	
	/**
	 * 
	 * @param identification
	 * @param typeIdentification
	 * @param username
	 * @param password
	 */
	public User(String identification, String typeIdentification, String username, String password) {
		super(identification, typeIdentification);
		this.username = username;
		this.password = password;
	}
}
	
