package co.com.ajac.acl.personaservice;

import co.com.ajac.acl.personaservice.modelos.AdministradorDTO;
import co.com.ajac.acl.personaservice.modelos.PersonaJuridicaDTO;
import co.com.ajac.domain.propiedadeshorizontales.Administrador;
import io.vavr.control.Option;

public interface ServicePersonaCommunicator {
	
	Option<PersonaJuridicaDTO> obtenerPersonaJuridicaDTODesdeService(String nit);
	
	Option<AdministradorDTO> obtenerAdministradorDTODesdeService(Administrador administrador);
}
