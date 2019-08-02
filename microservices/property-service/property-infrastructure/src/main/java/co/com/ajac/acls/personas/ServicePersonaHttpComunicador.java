package co.com.ajac.acls.personas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ajac.acl.personaservice.ServicePersonaCommunicator;
import co.com.ajac.acl.personaservice.modelos.AdministradorDTO;
import co.com.ajac.acl.personaservice.modelos.PersonaJuridicaDTO;
import co.com.ajac.domain.propiedadeshorizontales.Administrador;
import co.com.ajac.infrastructure.acl.communicator.Communicator;
import io.vavr.control.Option;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ServicePersonaHttpComunicador implements ServicePersonaCommunicator, Communicator{


	private static final String PERSON_SERVICE_URL = "http://localhost:8001/person/api/v1/";
	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;
	
	@Autowired
	public ServicePersonaHttpComunicador(RestTemplate restTemplate, ObjectMapper objectMapper) {
		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper;
	}

	@Override
	public Option<PersonaJuridicaDTO> obtenerPersonaJuridicaDTODesdeService(String nit) {
		log.debug("Obteniendo persona juridica para este nit", nit);
		return getApi(
				objectMapper,
				restTemplate,
				PERSON_SERVICE_URL.concat("persona-juridica/").concat(nit),
				PersonaJuridicaDTO.class);
	}

	@Override
	public Option<AdministradorDTO> obtenerAdministradorDTODesdeService(Administrador administrador) {
		
		return Option.of(new AdministradorDTO());
	}

	
}
