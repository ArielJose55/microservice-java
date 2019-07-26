package co.com.ajac.acl;

import co.com.ajac.domain.propiedadeshorizontales.Administrador;

public interface PersonCommunicator {

	boolean consultarExistenciaDePersonaJuridica(Administrador administrador);
}
