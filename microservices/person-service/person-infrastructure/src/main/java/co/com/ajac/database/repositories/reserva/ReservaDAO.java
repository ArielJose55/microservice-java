package co.com.ajac.database.repositories.reserva;

import java.sql.Timestamp;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
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
	
	
	
	@SqlQuery("SELECT * FROM \"RESERVA\" re"
			+ "	WHERE"
			+ "	re.estado_reserva = :estadoReserva"
			+ "	AND"
			+ "	re.bien_comun = :bienComun")
	List<ReservaRecord> listarTodasLasReservaPorEstadoYPorBienComun(
			@Bind("estadoReserva") String estadoReserva,
			@Bind("bienComun") Integer bienComun);
	
	
	@SqlQuery("SELECT * FROM \"RESERVA\" re"
			+ "	WHERE"
			+ "	re.tipoIdentificacion = :tipoIdentificacion"
			+ "	AND"
			+ "	re.numero_identificacion = :numeroIdentificacion")
	List<ReservaRecord> listarTodasLasReservaDeUnResidente(
			@Bind("tipoIdentificacion") String tipoIdentificacion,
			@Bind("numeroIdentificacion") String numeroIdentificacion);
	
	
	@SqlQuery("SELECT * FROM \"RESERVA\" re"
			+ "	WHERE re.bien_comun = :IdPripiedadComun"
			+ "	AND"
			+ "	re.estado_reserva = :estadoReserva"
			+ "	EXCEPT"
			+ "		SELECT * FROM person.\"RESERVA\" re " + 
			"				WHERE"
			+ "				(re.fecha_finalizacion < :fechaInicio OR re.fecha_inicio > :fechaFinal)"
			+ "				AND"
			+ "				re.bien_comun = :IdPripiedadComun" + 
			"				AND\n" + 
			"				re.estado_reserva = :estadoReserva")
	List<ReservaRecord> listarReservasChuzadasConEstas(
			@Bind("estadoReserva") String estadoReserva,
			@Bind("fechaInicio") Timestamp fechaInicio,
			@Bind("fechaFinal") Timestamp fechaFinal,
			@Bind("IdPripiedadComun") Integer IdPripiedadComun);
	
}
