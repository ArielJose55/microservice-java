package co.com.ajac.database.repositories.residente;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;

import io.vavr.control.Option;

public interface ResidenteDAO {
	
	boolean registrarResidente(
			@BindBean("res") ResidenteRecord record);
	
	Option<ResidenteRecord> obtenerResidentePorSuIdentificacion(
			@Bind("tipoId") String tipoId,
			@Bind("numId") String numId);

}
