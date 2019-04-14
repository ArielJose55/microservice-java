package co.com.ajac.database.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.database.repositories.ResidentRepository;
import co.com.ajac.models.Pet;
import co.com.ajac.models.Resident;
import co.com.ajac.ports.IResidentRepository;

@Component
public class ResidentRepositoryAdapter implements IResidentRepository{

	@Autowired
	private ResidentRepository repository;

	@Override
	public Optional<Resident> save(Resident resident) {
		return repository.create(resident);
	}

	@Override
	public Optional<Resident> get(String identification) {
		return repository.get(identification);
	}

	@Override
	public Optional<Pet> addHimPet(Pet pet, String onwerIdentification) {
		return repository.addHimPet(pet, onwerIdentification);
	}

	@Override
	public Optional<List<Pet>> listPetsByResident(String onwerIdentification) {
		return repository.getPetsByResident(onwerIdentification);
	}

	@Override
	public Optional<List<Resident>> listAllResident() {
		return repository.getAll();
	}
	
	
}
