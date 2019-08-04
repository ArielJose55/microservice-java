package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.builders.ResidenteBuilder;
import co.com.ajac.dtos.ResidenteDTO;
import co.com.ajac.entities.residentes.Residente;
import co.com.ajac.services.ResidenteService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class RegistrarResidenteCommand implements Command<ResidenteDTO>{
	
	private final ResidenteService residenteService;

	@Autowired
	public RegistrarResidenteCommand(ResidenteService residenteService) {
		this.residenteService = residenteService;
	}

	@Override
	public void execute(ResidenteDTO residenteDTO) {
		
		log.info("Ejecutando el comando: RegistrarResidenteCommand con los datos: {}", residenteDTO);
		Residente residente = ResidenteBuilder.crearResidenteDesdeRequest(residenteDTO);

		residenteService.registrarResidente(residente);
	}

}
