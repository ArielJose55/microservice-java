package co.com.ajac.acls.personas;

import org.springframework.stereotype.Component;

import co.com.ajac.acl.PersonCommunicator;
import co.com.ajac.domain.phs.Administrador;
import infrastructure.http.Communicator;

@Component
public class PersonaHttpComunicador implements PersonCommunicator, Communicator{


	@Override
	public boolean consultarExistenciaDePersonaJuridica(Administrador administrador) {
		// TODO Auto-generated method stub
		return true;
	}

}
