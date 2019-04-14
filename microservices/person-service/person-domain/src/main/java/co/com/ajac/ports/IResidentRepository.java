package co.com.ajac.ports;

import java.util.List;
import java.util.Optional;

import co.com.ajac.models.Pet;
import co.com.ajac.models.Resident;

public interface IResidentRepository {
	
	public Optional<Resident> save(Resident resident);
	
	public Optional<Resident> get(String identification);
	
	public Optional<Pet> addHimPet(Pet pet, String onwerIdentification);
	
	public Optional<List<Pet>> listPetsByResident(String onwerIdentification);
	
	public Optional<List<Resident>> listAllResident();
}
