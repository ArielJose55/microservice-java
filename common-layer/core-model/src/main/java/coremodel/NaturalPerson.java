package coremodel;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public abstract class NaturalPerson extends Person {

	private static final String FIELD_NOT_EMPTY = "Este campo no puede estar vacio";
	
	@NotEmpty(message = FIELD_NOT_EMPTY)
	protected String name;
	
	@NotEmpty(message = FIELD_NOT_EMPTY)
	protected String lastName;
	
	public NaturalPerson(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}

	/**
	 * @param identification
	 * @param typeIdentification
	 * @param name
	 * @param lastName
	 */
	public NaturalPerson(String identification, String typeIdentification, String name, String lastName) {
		super(identification, typeIdentification);
		this.name = name;
		this.lastName = lastName;
	}
}
