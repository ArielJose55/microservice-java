package co.com.ajac.services;

import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.entities.personasjuridicas.PersonaJuridica;
import co.com.ajac.ports.PersonaJuridicaRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonaJuridicaService {

	private final PersonaJuridicaRepository personaJuridicaRepository;

	public PersonaJuridicaService(PersonaJuridicaRepository personaJuridicaRepository) {
		this.personaJuridicaRepository = personaJuridicaRepository;
	}
	
	public PersonaJuridica guardarPersonaJuridica(PersonaJuridica personaJuridica) {
		
		if(personaJuridicaRepository.obtenerPersonaJuridicaPorNit(personaJuridica.getNit()).isDefined()) {
			log.error("Ya existe en una persona juridica registrada con  este nit: {}", personaJuridica.getNit());
			throw new BusinessException("Ya existe una persona juridica registrada con  este nit");
		}
		
		log.debug("Persistiendo esta persona juridica: {}", personaJuridica);
		return personaJuridicaRepository.registrarPersonaJuridica(personaJuridica);
	}
	
	public PersonaJuridica obtenerPersonaJuridicaPorSuNit(String nit) {
		return personaJuridicaRepository.obtenerPersonaJuridicaPorNit(nit)
				.getOrElseThrow(() -> new BusinessException("No existe una persona juridica registrada con  este nit"));
	}
}
