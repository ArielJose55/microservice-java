package coremodel;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LegalPerson extends Person {
	
	private static final String FIELD_NOT_EMPTY = "Este campo no puede estar vacio";
	
	
	
	@NotEmpty(message = FIELD_NOT_EMPTY)
	protected String businessName;
	
	@NotEmpty(message = FIELD_NOT_EMPTY)
	protected String socialObjective;
	
	public LegalPerson(String identification) {
		super(identification);
	}

	public LegalPerson(String identification, String typeIdentification, String businessName, String socialObjective) {
		super(identification, typeIdentification);
		this.businessName = businessName;
		this.socialObjective = socialObjective;
	}
}
