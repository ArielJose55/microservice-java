package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.PersonCommunicator;
import co.com.ajac.acl.builders.PropiedadHorizontalBuilder;
import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import co.com.ajac.dtos.PropiedadHorizontalDTO;
import co.com.ajac.event.personas.builders.PersonaJuridicaBuilder;
import co.com.ajac.events.Publish;
import co.com.ajac.services.PropiedadHorizontalService;
import io.vavr.concurrent.Future;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class RegistrarPropiedadHorizontalCommand implements Command<PropiedadHorizontalDTO> {

	private final PropiedadHorizontalService propiedadHorizontalService;
	private final PersonCommunicator personCommunicator;
	private final Publish publish;

	@Autowired
	public RegistrarPropiedadHorizontalCommand(PropiedadHorizontalService propiedadHorizontalService,
			PersonCommunicator personCommunicator, Publish publish) {
		this.propiedadHorizontalService = propiedadHorizontalService;
		this.personCommunicator = personCommunicator;
		this.publish = publish;
	}

	@Override
	public void execute(PropiedadHorizontalDTO propiedadHorizontalDTO){

		final long startTime = System.currentTimeMillis();

		PropiedadHorizontal propiedadHorizontal = PropiedadHorizontalBuilder
				.crearPropiedadHorizontalDesdeDTO(propiedadHorizontalDTO);

		log.info("verificando la existencia del administrador con datos: {}, {}", propiedadHorizontalDTO.getNumId(),
				propiedadHorizontalDTO.getTipoId());

		if (!personCommunicator.consultarExistenciaDePersonaJuridica(propiedadHorizontal.getAdministrador())) {
			log.error("No existe este administrador {} en el sistema", propiedadHorizontal.getAdministrador());
			throw new BusinessException("No existe ningun administrador registrado con identificacion");
		}

		log.info("La existencia del administrador con datos: {}, {} fue verificada", propiedadHorizontalDTO.getNumId(),
				propiedadHorizontalDTO.getTipoId());
		
		 propiedadHorizontalService.registrarrHorizontalProperty(propiedadHorizontal);
		
		 Future.of(() -> PersonaJuridicaBuilder.crearPersonaJuridicaMensajeDesdeEntidad(propiedadHorizontalDTO))
		 	.map(publish::onMessage)
		 	.onSuccess(ok -> {
		 		final long elapsedTime = System.currentTimeMillis() - startTime;
				log.debug("RegistrarPropiedadHorizontalCommand: Finaliza procesamiento, time: {" + elapsedTime
						+ "} ms.");
		 	})
		 	.onFailure(error -> {
		 		final long elapsedTime = System.currentTimeMillis() - startTime;
				log.warn("RegistrarPropiedadHorizontalCommand: Finaliza con error: {}, time: {} ms.",
						error.getCause(), elapsedTime);
				throw new BusinessException(error.getCause().getMessage());
		 	});
		 
		
	}
}
