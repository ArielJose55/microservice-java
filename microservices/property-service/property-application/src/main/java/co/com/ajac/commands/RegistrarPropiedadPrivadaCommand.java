package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.builders.PropiedadPrivadaBuilder;
import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import co.com.ajac.dtos.PropiedadPrivadaDTO;
import co.com.ajac.services.PropiedadHorizontalService;
import co.com.ajac.services.PropiedadPrivadaService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class RegistrarPropiedadPrivadaCommand implements Command<PropiedadPrivadaDTO>{

	private final PropiedadPrivadaService propiedadPrivadaService;
	private final PropiedadHorizontalService propiedadHorizontalService;
	
	@Autowired
	public RegistrarPropiedadPrivadaCommand(PropiedadPrivadaService propiedadPrivadaService, PropiedadHorizontalService propiedadHorizontalService) {
		this.propiedadPrivadaService = propiedadPrivadaService;
		this.propiedadHorizontalService = propiedadHorizontalService;
	}

	@Override
	public void execute(PropiedadPrivadaDTO propiedadPrivadaDTO) {
		
		log.debug("Ejecutando el comando: RegistrarPropiedadPrivadaCommand con request: {}", propiedadPrivadaDTO);
		PropiedadHorizontal propiedadHorizontal = propiedadHorizontalService.obtenerPropiedadHorizontalPorNit(propiedadPrivadaDTO.getPropiedadHorizontal());
	
		log.debug("Se encontraron datos de la propiedad: {}", propiedadHorizontal);
		
		propiedadPrivadaService.registrarNuevaPropiedadPrivada(
				PropiedadPrivadaBuilder.crearPropiedadPrivadaDesdeDTO(propiedadHorizontal, propiedadPrivadaDTO));		
	}

	
}
