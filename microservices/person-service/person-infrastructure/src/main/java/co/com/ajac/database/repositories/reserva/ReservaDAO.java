package co.com.ajac.database.repositories.reserva;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import io.vavr.collection.List;

@RegisterRowMapper(ReservaMapper.class)
public interface ReservaDAO {

	@SqlUpdate("INSERT INTO \"RESERVA\"\n" + 
			"("
			+ "	descripcion,"
			+ "	estado_reserva,"
			+ "	fecha_inicio,"
			+ "	fecha_finalizacion,"
			+ "	bien_comun,"
			+ "	numero_identificacion,"
			+ "	tipo_identificacion)"
			+ "	VALUES("
			+ "	:reserva.descripcion,"
			+ "	:reserva.estadoReserva,"
			+ "	:reserva.fechaInicio,"
			+ "	:reserva.fechaFinalizacion,"
			+ "	:reserva.bienComun,"
			+ "	:reserva.tipoIdentificacion,"
			+ "	:reserva.numeroIdentificacion"
			+ ")" + 
			"")
	boolean registrarReserva(@BindBean("reserva") ReservaRecord reservaRecord);
	
	@SqlUpdate("SELECT * FROM \"RESERVA\" re"
			+ "	WHERE"
			+ "	re.estado_reserva = :estadoReserva"
			+ "	AND"
			+ "	re.bien_comun = :bienComun")
	List<ReservaRecord> listarTodasLasReservaPorEstadoYPorBienComun(
			@Bind("estadoReserva") String estadoReserva,
			@Bind("bienComun") Integer bienComun);
	
	@SqlUpdate("SELECT * FROM \"RESERVA\" re"
			+ "	WHERE"
			+ "	re.tipoIdentificacion = :tipoIdentificacion"
			+ "	AND"
			+ "	re.numero_identificacion = :numeroIdentificacion")
	List<ReservaRecord> listarTodasLasReservaDeUnResidente(
			@Bind("tipoIdentificacion") String tipoIdentificacion,
			@Bind("numeroIdentificacion") String numeroIdentificacion);
}
