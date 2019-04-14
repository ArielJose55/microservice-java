package co.com.ajac.usecase.resident;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.exceptions.ModelNotFoundException;
import co.com.ajac.models.Pet;
import co.com.ajac.services.resident.ResidentService;
import common.usecases.Query;

@Component
public class GetAllPetsByResident implements Query<List<Pet>, String>{

	private static final String RESIDENT_DOES_NOT_HAVE_PETS = "¡OuupS! Este residente aún no tiene mascotas registradas";
	private final ResidentService residentService;

	@Autowired
	public GetAllPetsByResident(ResidentService residentService) {
		this.residentService = residentService;
	}

	@Override
	public List<Pet> execute(String identificacion) {
		return residentService.listPets(identificacion)
				.orElseThrow(() -> new ModelNotFoundException(RESIDENT_DOES_NOT_HAVE_PETS));
	}	
}
