package co.com.ajac.models.administradors;

import coremodel.BiometricData;
import coremodel.LegalPerson;
import coremodel.NaturalPerson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Administrator extends NaturalPerson{

	private LegalPerson legalPerson;
	
	private TypeAdministrator typeAdministrator;

	public Administrator(String name, String lastName, BiometricData biometricData) {
		super(name, lastName, biometricData);
	}

	public Administrator(String identification, String typeIdentification, String name, String lastName) {
		super(identification, typeIdentification, name, lastName);
	}

	public Administrator(String identification, String typeIdentification) {
		super(identification, typeIdentification);
	}

	public Administrator(String identification) {
		super(identification);
	}
	
	
	
}
