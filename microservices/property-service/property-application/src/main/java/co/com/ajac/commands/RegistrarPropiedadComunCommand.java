package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.builders.PropiedadComunBuilder;
import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import co.com.ajac.dtos.PropiedadComunDTO;
import co.com.ajac.services.PropiedadComunService;
import co.com.ajac.services.PropiedadHorizontalService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class RegistrarPropiedadComunCommand implements Command<PropiedadComunDTO>{

	private final PropiedadComunService propiedadComunService;
	private final PropiedadHorizontalService propiedadHorizontalService;
	
	@Autowired
	public RegistrarPropiedadComunCommand(PropiedadComunService propiedadComunService, PropiedadHorizontalService propiedadHorizontalService) {
		this.propiedadComunService = propiedadComunService;
		this.propiedadHorizontalService = propiedadHorizontalService;
	}

	@Override
	public void execute(PropiedadComunDTO propiedadComunDTO) {
	
		log.debug("Ejecutando el comando: RegistrarPropiedadComunCommand con request: {}", propiedadComunDTO);
		PropiedadHorizontal propiedadHorizontal = propiedadHorizontalService.obtenerPropiedadHorizontalPorNit(propiedadComunDTO.getPropiedadHorizontal());
		
		propiedadComunService.registrarPropiedadComun(
				PropiedadComunBuilder.crearPropiedadCommunDesdeDTO(propiedadHorizontal, propiedadComunDTO));
	}
}
