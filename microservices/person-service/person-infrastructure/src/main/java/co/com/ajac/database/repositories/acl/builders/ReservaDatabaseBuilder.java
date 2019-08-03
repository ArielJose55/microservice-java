package co.com.ajac.database.repositories.acl.builders;

import java.sql.Timestamp;

import co.com.ajac.database.repositories.reserva.ReservaRecord;
import co.com.ajac.entities.residentes.reservas.EstadoReserva;
import co.com.ajac.entities.residentes.reservas.Reserva;
import coremodel.datosbasicos.Identificacion;

public class ReservaDatabaseBuilder {
	
	private ReservaDatabaseBuilder() {}
	
	public static Reserva crearReservaDesdeRecord(ReservaRecord record) {
		
		Identificacion identificacion = Identificacion.builder()
				.tipoIdentificacion(record.getTipoIdentificacion())
				.numeroIdentificacion(record.getNumeroIdentificacion())
				.build();
		
		return Reserva.builder()
			.idReserva(record.getIdReserva())
			.descripcion(record.getDescripcion())
			.estadoReserva(EstadoReserva.getEstadoReservaDesdeCodigo(record.getEstadoReserva()))
			.fechaInicio(record.getFechaInicio().toLocalDateTime())
			.fechaFinalizacion(record.getFechaFinalizacion().toLocalDateTime())
			.bienComun(record.getBienComun())
			.identificacion(identificacion)
			.build();
	}
	
	public static ReservaRecord crearReservaRecordDesdeEntidad(Reserva reserva) {
		return new ReservaRecord(
				null,
				reserva.getDescripcion(),
				reserva.getEstadoReserva().getCodigo(),
				Timestamp.valueOf(reserva.getFechaInicio()),
				Timestamp.valueOf(reserva.getFechaFinalizacion()),
				reserva.getBienComun(),
				reserva.getIdentificacion().getTipoIdentificacion(),
				reserva.getIdentificacion().getNumeroIdentificacion());
	}
	

}
