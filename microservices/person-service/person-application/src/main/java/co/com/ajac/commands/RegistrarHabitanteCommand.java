package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.builders.HabitanteBuilder;
import co.com.ajac.dtos.HabitanteDTO;
import co.com.ajac.entities.residentes.habitantes.Habitante;
import co.com.ajac.services.ResidenteService;
import coremodel.datosbasicos.Identificacion;

@Component
public class RegistrarHabitanteCommand implements Command<HabitanteDTO>{

	private final ResidenteService residenteService;

	@Autowired
	public RegistrarHabitanteCommand(ResidenteService residenteService) {
		this.residenteService = residenteService;
	}

	@Override
	public void execute(HabitanteDTO habitanteDTO) {
		Habitante habitante = HabitanteBuilder.crearHabitanteDesdeRequest(habitanteDTO);
		Identificacion identificacionResidente = Identificacion.builder()
				.tipoIdentificacion(habitanteDTO.getTipoIdResidente())
				.numeroIdentificacion(habitanteDTO.getNumIdResidente())
				.build();
		
		residenteService.registrarHabitanteAUnResidente(habitante, identificacionResidente);		
	}
	
	
}