package co.com.ajac.models.residents;



import coremodel.NaturalPerson;
import io.vavr.collection.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resident  extends NaturalPerson {

	private String type;
	
	private List<Pet> pets;
	
	private List<Habitant> habitantes;
	
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
