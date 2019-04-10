package co.com.ajac.coremodel;

import javax.validation.constraints.NotEmpty;

public abstract class NaturalPerson extends Person{
	
private static final String FIELD_NOT_EMPLY = "Este campo no puede estar vacío";
	
	@NotEmpty(message = FIELD_NOT_EMPLY)
	private String name;
	
	@NotEmpty(message = FIELD_NOT_EMPLY)
	private String lastName;
	
	public NaturalPerson(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}

	/**
	 * @param identification
	 * @param typeIdentification
	 * @param name
	 * @param lastName
	 */
	public NaturalPerson(String identification, String typeIdentification, String name,String lastName) {
		super(identification, typeIdentification);
		this.name = name;
		this.lastName = lastName;
	}
}
