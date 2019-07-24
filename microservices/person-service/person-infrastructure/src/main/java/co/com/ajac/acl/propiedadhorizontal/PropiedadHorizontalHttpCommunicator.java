package co.com.ajac.acl.propiedadhorizontal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ajac.acl.propiedadhorizontal.modelos.PropiedadHorizontalDTO;
import co.com.ajac.infrastructure.acl.communicator.Communicator;
import coremodel.datosbasicos.Identificacion;
import io.vavr.collection.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class PropiedadHorizontalHttpCommunicator implements PropiedadHorizontalCommunicator, Communicator{

	private static final String PROPERTY_SERVICE_URL = "http://localhost:8000/property/api/v1/phs/admin/";
	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;
	
	@Autowired
	public PropiedadHorizontalHttpCommunicator(RestTemplate restTemplate, ObjectMapper objectMapper) {
		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper;
	}

	@Override
	public List<PropiedadHorizontalDTO> obtenerTodasLasPropiedadesHorizontalesDeUnAdministrador(
			Identificacion identificacion) {
		log.debug("Obteniendo la lista de propiedades horizontales del administrador: {}", identificacion);
		return getApiList(
				objectMapper,
				restTemplate,
				PROPERTY_SERVICE_URL + identificacion.getTipoIdentificacion() + "/" + identificacion.getNumeroIdentificacion(),
				PropiedadHorizontalDTO.class);
	}
	
	
}
