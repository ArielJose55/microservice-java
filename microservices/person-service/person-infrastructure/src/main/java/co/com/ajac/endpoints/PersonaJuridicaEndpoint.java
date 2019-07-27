package co.com.ajac.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.acl.builders.PersonaJuridicaBuilder;
import co.com.ajac.dtos.PersonaJuridicaDTO;
import co.com.ajac.queries.PersonaJuridicaQuery;

@RestController
@RequestMapping("/person/api/v1")
public class PersonaJuridicaEndpoint {
	
	private final PersonaJuridicaQuery personaJuridicaQuery;

	@Autowired
	public PersonaJuridicaEndpoint(PersonaJuridicaQuery personaJuridicaQuery) {
		this.personaJuridicaQuery = personaJuridicaQuery;
	}
	
	@GetMapping("/persona-juridica/{nit}")
	public PersonaJuridicaDTO obtenerPersonaJuridica(@PathVariable("nit") String nit) {
		return PersonaJuridicaBuilder.crearPersonaJuridicaDTODesdeEntidad(
				personaJuridicaQuery.obtenerPersonaJuridicaPorNit(nit)
		);
	}

}
