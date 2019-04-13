package co.com.ajac.coremodel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person implements Model {

	private static final String IDENTIFICATION_NOT_ACCEPTED = "La identificacion debe tener entre {min} y {max} caracteres";

	private static final String IDENTIFICATION_REQUIRED = "¡Ouups! Lo siento, pero la identificacion no puede estar vacia";
	
	private static final String FIELD_NOT_EMPTY = "Este campo no puede estar vacio";
	
	@NotNull(message = IDENTIFICATION_REQUIRED)
	@Size(min = 5, max = 20, message = IDENTIFICATION_NOT_ACCEPTED)
	protected String identification;
	
	@NotNull(message = FIELD_NOT_EMPTY)
	protected String typeIdentification;
}
