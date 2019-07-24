package co.com.ajac.ports;

import co.com.ajac.entities.personasjuridicas.PersonaJuridica;
import io.vavr.control.Option;

public interface PersonaJuridicaRepository {

	PersonaJuridica registrarPersonaJuridica(PersonaJuridica personaJuridica);
	
	Option<PersonaJuridica> obtenerPersonaJuridicaPorNit(String nit);
}
