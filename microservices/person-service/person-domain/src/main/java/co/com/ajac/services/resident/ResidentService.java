package co.com.ajac.services.resident;

import java.util.List;
import java.util.Optional;

import co.com.ajac.models.Pet;
import co.com.ajac.models.Resident;
import co.com.ajac.ports.IResidentRepository;

public class ResidentService {

	private final IResidentRepository repository;
	
	/**
	 * @param repository
	 */
	public ResidentService(IResidentRepository repository) {
		this.repository = repository;
	}

	public Optional<Resident> create(Resident resident){
		return repository.save(resident);
	}
	
	public Optional<Resident> get(String identification){
		return repository.get(identification);
	}
	
	public Optional<List<Resident>> getAll(){
		return repository.listAllResident();
	}
	
	public Optional<List<Pet>> listPets(String identificacion){
		return repository.listPetsByResident(identificacion);
	}
	
	public Optional<Pet> registerPet(Pet pet){
		return repository.addHimPet(pet, pet.getIdentification());
	}
}
