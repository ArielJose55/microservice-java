package co.com.ajac.models;

import coremodel.NaturalPerson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Visitor extends NaturalPerson {

	/**
	 * @param identification
	 * @param typeIdentification
	 */
	public Visitor(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}

	
	
	/**
	 * @param identification
	 * @param typeIdentification
	 * @param name
	 * @param lastName
	 */
	public Visitor(String identification, String typeIdentification, String name, String lastName) {
		super(identification, typeIdentification, name, lastName);
	}
}
