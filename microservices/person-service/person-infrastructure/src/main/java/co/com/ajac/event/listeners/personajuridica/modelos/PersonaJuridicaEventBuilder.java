package co.com.ajac.event.listeners.personajuridica.modelos;

import co.com.ajac.entities.personasjuridicas.PersonaJuridica;

public class PersonaJuridicaEventBuilder {

	private PersonaJuridicaEventBuilder() {}
	
	public static PersonaJuridica crearPersonaJuridicaDesdeEvent(EventPersonaJuridicaMensaje eventPersonaJuridicaMensaje) {
		
		return PersonaJuridica.builder()
				.nit(eventPersonaJuridicaMensaje.getNit())
				.razonSocial(eventPersonaJuridicaMensaje.getRazonSocial())
				.objetoSocial(eventPersonaJuridicaMensaje.getObjetoSocial())
				.build();
	}
}
