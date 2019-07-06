package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.residents.Resident;
import co.com.ajac.services.resident.ResidentService;
import common.Command;
import domain.exceptions.NotSaveModelException;


@Component
public class RegisterResidentCommand implements Command<Resident>{
	
	private static final String UNREGISTERED_RESIDENT = "¡Ouups! Lo sentimos este residente no pudo ser registrado. Intentelo nuevamente";
	private final ResidentService residentService;

	@Autowired
	public RegisterResidentCommand(ResidentService residentService) {
		this.residentService = residentService;
	}

	@Override
	public void execute(Resident resident) {
		residentService.create(resident)
				.getOrElseThrow(() -> new NotSaveModelException(UNREGISTERED_RESIDENT));
	}

}
