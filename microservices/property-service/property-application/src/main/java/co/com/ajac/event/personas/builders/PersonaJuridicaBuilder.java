package co.com.ajac.event.personas.builders;

import co.com.ajac.dtos.PropiedadHorizontalDTO;
import co.com.ajac.event.personas.EventPersonaJuridicaMensaje;

public class PersonaJuridicaBuilder {
	
	private PersonaJuridicaBuilder() {}

	public static EventPersonaJuridicaMensaje crearPersonaJuridicaMensajeDesdeEntidad(PropiedadHorizontalDTO propiedadHorizontalDTO) {
		
		return new EventPersonaJuridicaMensaje(
				propiedadHorizontalDTO.getNit(),
				propiedadHorizontalDTO.getRazonSocial(),
				propiedadHorizontalDTO.getObjetoSocial());
	}	
}
 