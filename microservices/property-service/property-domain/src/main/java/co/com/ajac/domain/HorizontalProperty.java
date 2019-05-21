package co.com.ajac.domain;


import coremodel.LegalPerson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HorizontalProperty extends LegalPerson{
	
	private String distinctiveName;

	public HorizontalProperty(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}
	
	public HorizontalProperty(String identification, String typeIdentification, String distinctiveName, String businessName, String socialObjective) {
		super(identification, typeIdentification, businessName, socialObjective);
		this.distinctiveName = distinctiveName;
	}	
}
