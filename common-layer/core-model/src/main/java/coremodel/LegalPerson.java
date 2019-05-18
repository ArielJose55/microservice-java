package coremodel;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public abstract class LegalPerson extends Person {
	
	private static final String FIELD_NOT_EMPTY = "Este campo no puede estar vacio";

	protected Integer idLegalPerson;
	
	@NotEmpty(message = FIELD_NOT_EMPTY)
	protected String businessName;
	
	@NotEmpty(message = FIELD_NOT_EMPTY)
	protected String socialObjective;

	public LegalPerson(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}

	public LegalPerson(String identification, String typeIdentification, String businessName, String socialObjective) {
		super(identification, typeIdentification);
		this.businessName = businessName;
		this.socialObjective = socialObjective;
	}
	
	public LegalPerson(String identification, String typeIdentification, Integer idLegalPerson, String businessName, String socialObjective) {
		super(identification, typeIdentification);
		this.idLegalPerson = idLegalPerson;
		this.businessName = businessName;
		this.socialObjective = socialObjective;
	}
}
