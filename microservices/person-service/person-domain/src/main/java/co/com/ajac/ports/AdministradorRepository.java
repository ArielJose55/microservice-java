package co.com.ajac.ports;

import co.com.ajac.entities.administradores.Administrador;
import coremodel.datosbasicos.Identificacion;
import io.vavr.control.Option;

public interface AdministradorRepository {
	
	Administrador registrarAdministrador(Administrador administrador);
	Option<Administrador> obtenerAdministradorPorSuIdentificacion(Identificacion identification);
}
