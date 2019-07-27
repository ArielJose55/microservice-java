package co.com.ajac.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.entities.personasjuridicas.PersonaJuridica;
import co.com.ajac.services.PersonaJuridicaService;

@Component
public class PersonaJuridicaQuery {

	private final PersonaJuridicaService personaJuridicaService;

	@Autowired
	public PersonaJuridicaQuery(PersonaJuridicaService personaJuridicaService) {
		this.personaJuridicaService = personaJuridicaService;
	}

	public PersonaJuridica obtenerPersonaJuridicaPorNit(String nit) {
		return personaJuridicaService.obtenerPersonaJuridicaPorSuNit(nit);
	}

}
