package co.com.ajac.database.repositories;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.models.Pet;
import co.com.ajac.models.Resident;
import lombok.Cleanup;

@Repository
public class ResidentRepository {

	@Autowired
	private Jdbi jdbi;


	public Optional<Resident> create(Resident model) {

		@Cleanup
		Handle handle = jdbi.open();
		return handle.inTransaction(h -> {
			h.createUpdate(
					"INSERT INTO \"PERSON\"(identification, \"typeIdentification\") VALUES (:identification, :typeIdentification)")
					.bind("identification", model.getIdentification())
					.bind("typeIdentification", model.getTypeIdentification())
					.execute();

			h.createUpdate(
					"INSERT INTO \"NATURAL_PERSON\"( name, last_name, person_fk)	VALUES (:name, :last_name, :person_fk)")
					.bind("name", model.getName()).bind("last_name", model.getLastName())
					.bind("person_fk", model.getIdentification())
					.execute();

			return h.createUpdate(
					"INSERT INTO \"RESIDENT\"( type, person_natural_fk) VALUES (:type, :person_natural_fk)")
					.bind("type", model.getType())
					.bind("person_natural_fk", model.getIdentification())
					.executeAndReturnGeneratedKeys()
					.mapToBean(Resident.class)
					.findFirst();
		});
	}


	public Optional<Resident> get(String key) {
		
		@Cleanup
		Handle handle = jdbi.open();
		return handle.createQuery(
				"SELECT p.identification, p.\"typeIdentification\", np.\"name\", np.last_name, r.\"type\" FROM \"PERSON\" p JOIN \"NATURAL_PERSON\" np ON p.identification = np.person_fk JOIN \"RESIDENT\" r ON r.person_natural_fk = np.person_fk\r\n"
						+ "WHERE r.person_natural_fk = :identification")
				.bind("identification", key)
				.mapToBean(Resident.class)
				.findFirst();
	}

	public Optional<Pet> addHimPet(Pet pet, String identification) {
		
		@Cleanup
		Handle handle = jdbi.open();
		return handle.createUpdate("INSERT INTO public.\"PET\"(name, species, resident_fk) VALUES (:name, :species, :resident_fk)")
				.bind("name", pet.getName())
				.bind("species", pet.getSpecies())
				.bind("resident_fk", identification)
				.executeAndReturnGeneratedKeys()
				.mapToBean(Pet.class)
				.findFirst();
	}
	
	public Optional<List<Resident>> getAll(){
		
		@Cleanup
		Handle handle = jdbi.open();
		
		return Optional.ofNullable(handle.createQuery("SELECT p.identification, p.\"typeIdentification\", n.\"name\", n.last_name, r.\"type\" FROM \"PERSON\" p JOIN \"NATURAL_PERSON\" n ON p.identification = n.person_fk JOIN \"RESIDENT\" r ON r.person_natural_fk = n.person_fk")
				.mapToBean(Resident.class)
				.list());
	}
	
	public Optional<List<Pet>> getPetsByResident(String identification) {
		
		@Cleanup
		Handle handle = jdbi.open();
		
		return Optional.ofNullable(
				handle.createQuery("SELECT  name, species FROM  \"PET\" p JOIN \"RESIDENT\" r ON p.resident_fk = r.person_natural_fk"
						+" WHERE p.resident_fk = :identification")
					.bind("identification", identification)
					.mapToBean(Pet.class)
					.list()
				);
	}
}
