package co.com.ajac.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.builders.PropiedadComunBuilder;
import co.com.ajac.acl.builders.PropiedadHorizontalBuilder;
import co.com.ajac.acl.personaservice.ServicePersonaCommunicator;
import co.com.ajac.acl.personaservice.modelos.PersonaJuridicaDTO;
import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.domain.propiedadeshorizontales.Administrador;
import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import co.com.ajac.dtos.PropiedadHorizontalDTO;
import co.com.ajac.services.PropiedadHorizontalService;
import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class PropiedadHorizontalQuery {

	private final ServicePersonaCommunicator personCommunicator;
	private final PropiedadHorizontalService horizontalService;

	@Autowired
	public PropiedadHorizontalQuery(PropiedadHorizontalService horizontalService,
			ServicePersonaCommunicator personCommunicator) {
		this.personCommunicator = personCommunicator;
		this.horizontalService = horizontalService;
	}

	/**
	 * 
	 * @param administrador
	 * @return
	 */
	public List<PropiedadHorizontalDTO> listarPropiedadesHorizontalesDeUnAdministrador(Administrador administrador) {

		log.info("verificando la existencia del administrador con datos: {}, {}", administrador.getTipoIdentificacion(),
				administrador.getNumeroIdentificacion());

		if (!personCommunicator.obtenerAdministradorDTODesdeService(administrador).isDefined()) {
			log.error("No existe este administrador {} en el sistema", administrador);
			throw new BusinessException("No existe ningun administrador registrado con identificacion");
		}

		return horizontalService.listarTodasLasPropiedadesHorizontalesPorAdministrador(administrador)
				.map(PropiedadHorizontalBuilder::crearPropiedadHorizontalDTODesdeEntidad);
	}

	/**
	 * 
	 * @param nit
	 * @return
	 */
	public PropiedadHorizontalDTO obtenerPropiedadHorizontalPorNit(String nit) {
		
		log.info("Consultando los datos adicionales de la persona juridica de este nit: {}", nit);
		Option<PersonaJuridicaDTO> personaJuridica = personCommunicator.obtenerPersonaJuridicaDTODesdeService(nit);
		
		if(personaJuridica.isEmpty()) {
			log.error("La Persona con este nit: {} No existe como persona juridica en el microservicio de persona", nit);
			throw new BusinessException("No existe esta persona juridica en el microservicio de personas");
		}

		log.info("Obteniendo datos de la propiedad horizontal de NIT: {}", nit);
		PropiedadHorizontal propiedadHorizontal = horizontalService.obtenerPropiedadHorizontalCompletaPorNit(nit);
		

		PropiedadHorizontalDTO propiedadHorizontalDTO = PropiedadHorizontalBuilder
				.crearPropiedadHorizontalDTODesdeEntidad(propiedadHorizontal);

		propiedadHorizontalDTO.setPropiedadesComunes(propiedadHorizontal.getBienesCommunes()
				.map(PropiedadComunBuilder::crearPropiedadComunDTODesdeEntidad).toJavaList());
		
		propiedadHorizontalDTO.setObjetoSocial(personaJuridica.get().getObjetoSocial());
		propiedadHorizontalDTO.setRazonSocial(personaJuridica.get().getRazonSocial());

		return propiedadHorizontalDTO;
	}

}
