package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.models.residents.Pet;
import co.com.ajac.services.resident.ResidentService;
import common.Command;
import domain.exceptions.NotSaveModelException;

@Component
public class RegisterPetCommand implements Command<Pet>{

	private static final String UNREGISTERED_PET = "¡Ouups! Lo sentimos la mascota no pudo ser registrado. Intentelo nuevamente";
	private final ResidentService residentService;
	
	@Autowired
	public RegisterPetCommand(ResidentService residentService) {
		this.residentService = residentService;
	}

	@Override
	public void execute(Pet pet) {
		residentService.registerPet(pet)
				.orElseThrow(() -> new NotSaveModelException(UNREGISTERED_PET));
	}
}
