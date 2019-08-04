package co.com.ajac.database.repositories.residente;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import io.vavr.control.Option;

@RegisterRowMapper(ResidenteMapper.class)
public interface ResidenteDAO {
	
	@SqlUpdate("INSERT INTO \"RESIDENTE\" ("
			+ "	numero_identificacion,"
			+ "	tipo_identificacion,"
			+ "	plantilla_huella,"
			+ "	codigo_seguridad,"
			+ "	titular)"
			+ "	VALUES("
			+ "	:res.personaNaturalRecord.numeroIdentificacion,"
			+ "	:res.personaNaturalRecord.tipoIdentificacion,"
			+ "	:res.huellaPlantilla,"
			+ "	:res.codigoDeSeguridad,"
			+ "	:res.esTitular"
			+ ")")
	boolean registrarResidente(
			@BindBean("res") ResidenteRecord record);
	
	
	@SqlQuery("SELECT * FROM \"RESIDENTE\" res"
			+ "	JOIN \"PERSONA_NATURAL\" per"
			+ "	ON res.numero_identificacion = per.numero_identificacion"
			+ "	AND res.tipo_identificacion = per.tipo_identificacion"
			+ "	WHERE"
			+ "	res.numero_identificacion = :numId"
			+ "	AND"
			+ "	res.tipo_identificacion = :tipoId"
			+ "")
	Option<ResidenteRecord> obtenerResidentePorSuIdentificacion(
			@Bind("tipoId") String tipoId,
			@Bind("numId") String numId);
	
	
	@SqlQuery("SELECT res.titular FROM \"RESIDENTE\" res"
			+ "	WHERE"
			+ "	res.numero_identificacion = :numId"
			+ "	AND"
			+ "	res.tipo_identificacion = :tipoId"
			+ "")
	boolean consultarLaTitularidadDeUnResidente(
			@Bind("tipoId") String tipoId,
			@Bind("numId") String numId);
	
}
