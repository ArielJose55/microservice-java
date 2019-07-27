package co.com.ajac.acl.builders;

import co.com.ajac.dtos.PersonaJuridicaDTO;
import co.com.ajac.entities.personasjuridicas.PersonaJuridica;

public class PersonaJuridicaBuilder {

	private PersonaJuridicaBuilder() {}
	
	public static PersonaJuridicaDTO crearPersonaJuridicaDTODesdeEntidad(PersonaJuridica personaJuridica) {
		return PersonaJuridicaDTO.builder()
			.nit(personaJuridica.getNit())
			.razonSocial(personaJuridica.getRazonSocial())
			.objetoSocial(personaJuridica.getObjetoSocial())
			.direccion(personaJuridica.getDireccion())
			.correoElectronico(personaJuridica.getCorreoElectronico())
			.telefono(personaJuridica.getTelefono())
			.build();
	}
}
