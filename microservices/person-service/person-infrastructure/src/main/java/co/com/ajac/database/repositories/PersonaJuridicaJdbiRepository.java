package co.com.ajac.database.repositories;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.database.repositories.acl.builders.PersonaJuridicaDatabaseBuilder;
import co.com.ajac.database.repositories.personajuridica.PersonaJuridicaDAO;
import co.com.ajac.entities.personasjuridicas.PersonaJuridica;
import co.com.ajac.ports.PersonaJuridicaRepository;
import io.vavr.control.Option;

@Repository
public class PersonaJuridicaJdbiRepository implements PersonaJuridicaRepository{
	
	private final PersonaJuridicaDAO personaJuridicaDAO;

	@Autowired
	public PersonaJuridicaJdbiRepository(Jdbi jdbi) {
		this.personaJuridicaDAO = jdbi.onDemand(PersonaJuridicaDAO.class);
	}

	@Override
	public PersonaJuridica registrarPersonaJuridica(PersonaJuridica personaJuridica) {
		personaJuridicaDAO.registrarPersonaJuridica(
				PersonaJuridicaDatabaseBuilder.crearPersonaJuridicaRecordDesdeEntidad(personaJuridica));
		return personaJuridica;
	}

	@Override
	public Option<PersonaJuridica> obtenerPersonaJuridicaPorNit(String nit) {
		return personaJuridicaDAO.obtenerPersonaJuridica(nit)
				.map(PersonaJuridicaDatabaseBuilder::crearPersonaJuridicaDesdeRecord);
	}

}
