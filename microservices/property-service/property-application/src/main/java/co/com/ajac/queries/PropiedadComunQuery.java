package co.com.ajac.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.personaservice.ServicePersonaCommunicator;
import co.com.ajac.services.PropiedadComunService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class PropiedadComunQuery {

	private final ServicePersonaCommunicator personCommunicator;
	private final PropiedadComunService propiedadComunService;

	@Autowired
	public PropiedadComunQuery(PropiedadComunService propiedadComunService, ServicePersonaCommunicator personCommunicator) {
		this.personCommunicator = personCommunicator;
		this.propiedadComunService = propiedadComunService;
	}

	
}