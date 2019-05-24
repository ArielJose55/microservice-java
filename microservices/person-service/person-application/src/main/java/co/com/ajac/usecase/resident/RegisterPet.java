package co.com.ajac.usecase.resident;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.exceptions.NotSaveModelException;
import co.com.ajac.models.residents.Pet;
import co.com.ajac.services.resident.ResidentService;
import common.Query;

@Component
public class RegisterPet implements Query<Pet, Pet>{

	private static final String UNREGISTERED_PET = "¡Ouups! Lo sentimos la mascota no pudo ser registrado. Intentelo nuevamente";
	private final ResidentService residentService;
	
	@Autowired
	public RegisterPet(ResidentService residentService) {
		this.residentService = residentService;
	}

	@Override
	public Pet execute(Pet pet) {
		return residentService.registerPet(pet)
				.orElseThrow(() -> new NotSaveModelException(UNREGISTERED_PET));
	}
}
