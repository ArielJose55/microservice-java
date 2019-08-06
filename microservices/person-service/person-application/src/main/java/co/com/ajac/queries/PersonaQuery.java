package co.com.ajac.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.entities.personasjuridicas.PersonaJuridica;
import co.com.ajac.services.PersonaJuridicaService;
import co.com.ajac.services.ResidenteService;

@Component
public class PersonaQuery {

	private final PersonaJuridicaService personaJuridicaService;
	private final ResidenteService residenteService;

	@Autowired
	public PersonaQuery(PersonaJuridicaService personaJuridicaService, ResidenteService residenteService) {
		this.personaJuridicaService = personaJuridicaService;
		this.residenteService = residenteService;
	}

	public PersonaJuridica obtenerPersonaJuridicaPorNit(String nit) {
		return personaJuridicaService.obtenerPersonaJuridicaPorSuNit(nit);
	}

	
}
