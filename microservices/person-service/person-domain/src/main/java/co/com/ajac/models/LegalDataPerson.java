package co.com.ajac.models;

import coremodel.LegalPerson;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LegalDataPerson extends LegalPerson{
	
	public LegalDataPerson(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}

	public LegalDataPerson(String identification, String typeIdentification, String businessName, String socialObjective) {
		super(identification, typeIdentification, businessName, socialObjective);
	}

	@Override
	public String toString() {
		return "LegalDataPerson [identification=" + identification + ", typeIdentification=" + typeIdentification  
				+ ", businessName=" + businessName + ", socialObjective=" + socialObjective + "]";
	}
}
