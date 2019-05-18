package co.com.ajac.models;

import coremodel.LegalPerson;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LegalDataPerson extends LegalPerson{

	public LegalDataPerson(String identification, String typeIdentification, Integer idLegalPerson, String businessName,
			String socialObjective) {
		super(identification, typeIdentification, idLegalPerson, businessName, socialObjective);
	}

	public LegalDataPerson(String identification, String typeIdentification, String businessName,
			String socialObjective) {
		super(identification, typeIdentification, businessName, socialObjective);
	}

	public LegalDataPerson(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}

	@Override
	public String toString() {
		return "LegalDataPerson [idLegalPerson=" + idLegalPerson + ", businessName=" + businessName
				+ ", socialObjective=" + socialObjective + ", identification=" + identification
				+ ", typeIdentification=" + typeIdentification + "]";
	}
}
