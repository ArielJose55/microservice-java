package co.com.ajac.database.repositories.acl.builders;

import co.com.ajac.database.repositories.personajuridica.PersonaJuridicaRecord;
import co.com.ajac.entities.personasjuridicas.PersonaJuridica;

public class PersonaJuridicaDatabaseBuilder {

	private PersonaJuridicaDatabaseBuilder() {}
	
	public static PersonaJuridicaRecord crearPersonaJuridicaRecordDesdeEntidad(PersonaJuridica personaJuridica) {
		return new PersonaJuridicaRecord(
				personaJuridica.getNit(),
				personaJuridica.getRazonSocial(),
				personaJuridica.getObjetoSocial());
	}
	
	public static PersonaJuridica crearPersonaJuridicaDesdeRecord(PersonaJuridicaRecord personaJuridicaRecord) {
		return PersonaJuridica.builder()
				.nit(personaJuridicaRecord.getNit())
				.razonSocial(personaJuridicaRecord.getRazonSocial())
				.objetoSocial(personaJuridicaRecord.getObjetoSocial())
				.build();
	}
}
