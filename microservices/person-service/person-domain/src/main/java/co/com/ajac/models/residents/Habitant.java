package co.com.ajac.models.residents;

import coremodel.BiometricData;
import coremodel.NaturalPerson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder()
@NoArgsConstructor
@AllArgsConstructor
public final class Habitant extends NaturalPerson{

	private String relacion;

	public Habitant(String name, String lastName, BiometricData biometricData) {
		super(name, lastName, biometricData);
		// TODO Auto-generated constructor stub
	}

	public Habitant(String identification, String typeIdentification, String name, String lastName) {
		super(identification, typeIdentification, name, lastName);
		// TODO Auto-generated constructor stub
	}

	public Habitant(String identification, String typeIdentification) {
		super(identification, typeIdentification);
		// TODO Auto-generated constructor stub
	}
}
