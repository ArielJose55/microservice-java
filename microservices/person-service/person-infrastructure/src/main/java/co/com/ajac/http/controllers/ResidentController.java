package co.com.ajac.http.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.models.Pet;
import co.com.ajac.models.Resident;
import co.com.ajac.usecase.resident.CreateResident;
import co.com.ajac.usecase.resident.GetAllPetsByResident;
import co.com.ajac.usecase.resident.GetAllResident;
import co.com.ajac.usecase.resident.GetResident;
import co.com.ajac.usecase.resident.RegisterPet;

@RestController
@RequestMapping("/residents")
public class ResidentController {
	
	private final CreateResident createResident;
	
	private final GetResident getResident;
	
	private final GetAllResident getAllResident;
	
	private final RegisterPet registerPet;
	
	private final GetAllPetsByResident petsByResident;
	
	@Autowired
	public ResidentController(CreateResident createResident, GetResident getResident, GetAllResident getAllResident
			,RegisterPet registerPet, GetAllPetsByResident petsByResident) {
		this.createResident = createResident;
		this.getResident = getResident;
		this.getAllResident = getAllResident;
		this.registerPet = registerPet;
		this.petsByResident = petsByResident;
	}

	@PostMapping
	public Resident add(@Valid @RequestBody Resident resident) {
		return createResident.execute(resident);
	}
	
	@GetMapping("/{id}")
	public Resident get(@PathVariable("id") String identification) {
		return getResident.execute(identification);
	}
	
	@GetMapping
	public List<Resident> getAll(){
		return getAllResident.execute();
	}
	
	@PostMapping("/pets")
	public Pet addPet(@Valid @RequestBody Pet pet) {
		return registerPet.execute(pet);
	}
	
	@GetMapping("/{id}/pets")
	public List<Pet> getAllPetByResident(@PathVariable("id") String identification){
		return petsByResident.execute(identification);
	}
}
