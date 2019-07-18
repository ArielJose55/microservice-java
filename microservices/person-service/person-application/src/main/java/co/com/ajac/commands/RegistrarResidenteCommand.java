package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.entities.residentes.Residente;
import co.com.ajac.services.residente.ResidenteService;
import commands.Command;
import domain.exceptions.NotSaveModelException;


@Component
public class RegistrarResidenteCommand implements Command<Residente>{
	
	private static final String UNREGISTERED_RESIDENT = "¡Ouups! Lo sentimos este residente no pudo ser registrado. Intentelo nuevamente";
	private final ResidenteService residentService;

	@Autowired
	public RegistrarResidenteCommand(ResidenteService residentService) {
		this.residentService = residentService;
	}

	@Override
	public void execute(Residente resident) {
		residentService.registrarResidente(resident);
	}

}
