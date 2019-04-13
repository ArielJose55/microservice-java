package co.com.ajac.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import co.com.ajac.coremodel.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class User extends Person {

	private static final String REGISTER_DATE_NOT_ACCEPTED = "La fecha de registro no puede ser futura";

	private static final String FIELD_NOT_EMPLY = "Este campo no puede estar vacio";

	private static final String USERNAME_NOT_ACCEPTED = "La username debe tener una longitud de entre {min} y {max} caracteres";

	@NotEmpty(message = FIELD_NOT_EMPLY)
	@Size(min = 5, max = 20, message = USERNAME_NOT_ACCEPTED)
	private String username;
	
	@NotEmpty(message = FIELD_NOT_EMPLY)
	private String password;
	
	@PastOrPresent(message = REGISTER_DATE_NOT_ACCEPTED)
	private LocalDateTime registerDate;

	@NotEmpty(message = FIELD_NOT_EMPLY)
	private String state;
	
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
		this(identification, typeIdentification);
		this.username = username;
		this.password = password;
	}

	/**
	 * @param identification
	 * @param typeIdentification
	 * @param username
	 * @param password
	 * @param registerDate
	 * @param state
	 */
	public User(String identification, String typeIdentification, String username, String password, LocalDateTime registerDate, String state) {
		this(identification, typeIdentification, username, password);
		this.registerDate = registerDate;
		this.state = state;
	}
}