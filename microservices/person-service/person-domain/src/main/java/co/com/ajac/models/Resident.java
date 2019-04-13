package co.com.ajac.models;



import co.com.ajac.coremodel.NaturalPerson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Resident  extends NaturalPerson {

	private String type;
	
	/**
	 * @param identification
	 * @param typeIdentification
	 */
	public Resident(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}

	/**
	 * @param identification
	 * @param typeIdentification
	 * @param name
	 * @param lastName
	 */
	public Resident(String identification, String typeIdentification, String name, String lastName) {
		super(identification, typeIdentification, name, lastName);
	}
	
	/**
	 * @param identification
	 * @param typeIdentification
	 * @param name
	 * @param lastName
	 * @param type
	 */
	public Resident(String identification, String typeIdentification, String name, String lastName, String type) {
		this(identification, typeIdentification, name, lastName);
		this.type = type;
	}
}
