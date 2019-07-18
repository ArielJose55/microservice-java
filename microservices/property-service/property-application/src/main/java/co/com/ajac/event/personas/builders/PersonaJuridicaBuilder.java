package co.com.ajac.event.personas.builders;

import co.com.ajac.dtos.PropiedadHorizontalDTO;
import co.com.ajac.event.personas.EventPersonaJuridicaMensaje;
import coremodel.persona.personanatural.Identificacion;

public class PersonaJuridicaBuilder {
	
	private PersonaJuridicaBuilder() {}

	public static EventPersonaJuridicaMensaje crearPersonaJuridicaMensajeDesdeEntidad(PropiedadHorizontalDTO propiedadHorizontalDTO) {
		
		Identificacion identificacion = new Identificacion(
				propiedadHorizontalDTO.getNumId(),
				propiedadHorizontalDTO.getTipoId());
		
		return new EventPersonaJuridicaMensaje(
				identificacion,
				propiedadHorizontalDTO.getRazonSocial(),
				propiedadHorizontalDTO.getObjetoSocial());
	}	
}
