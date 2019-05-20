package co.com.ajac.domain;


import coremodel.LegalPerson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HorizontalProperty extends LegalPerson{

	private Integer id;
	
	private String distinctiveName;

	public HorizontalProperty(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}
	
	public HorizontalProperty(String identification, String typeIdentification, Integer id, String distinctiveName, String businessName, String socialObjective) {
		super(identification, typeIdentification, businessName, socialObjective);
		this.id = id;
		this.distinctiveName = distinctiveName;
	}
}
