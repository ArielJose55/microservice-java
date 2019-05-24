package co.com.ajac.services.resident;

import java.util.List;
import java.util.Optional;

import co.com.ajac.models.residents.Pet;
import co.com.ajac.models.residents.Resident;
import co.com.ajac.ports.ResidentRepository;
import io.vavr.control.Option;

public class ResidentService {

	private final ResidentRepository repository;
	
	/**
	 * @param repository
	 */
	public ResidentService(ResidentRepository repository) {
		this.repository = repository;
	}

	public Option<Resident> create(Resident resident){
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
