package co.com.ajac.acl.builders;

import co.com.ajac.dtos.ReservaDTO;
import co.com.ajac.entities.residentes.reservas.EstadoReserva;
import co.com.ajac.entities.residentes.reservas.Reserva;
import coremodel.datosbasicos.Identificacion;

public class ReservaBuilder {

	private ReservaBuilder() {}
	
	public static Reserva crearReservaDesdeRequest(ReservaDTO reservaDTO) {
		return Reserva.builder()
				.idReserva(null)
				.bienComun(reservaDTO.getIdBienComun())
				.descripcion(reservaDTO.getDescripcion())
				.estadoReserva(EstadoReserva.TRAMITE)
				.respuesta(reservaDTO.getRespuesta())
				.fechaInicio(reservaDTO.getFechaInicio())
				.fechaFinalizacion(reservaDTO.getFechaFinalizacion())
				.identificacion(Identificacion.builder()
						.numeroIdentificacion(reservaDTO.getNumeroIdentificacion())
						.tipoIdentificacion(reservaDTO.getTipoIdentificacion())
						.build())
				.build();
	}
	
	public static ReservaDTO crearReservaDTODesdeEntidad(Reserva reserva) {
		return ReservaDTO.builder()
				.idReserva(reserva.getIdReserva())
				.descripcion(reserva.getDescripcion())
				.estadoReserva(reserva.getEstadoReserva().getCodigo())
				.fechaInicio(reserva.getFechaInicio())
				.fechaFinalizacion(reserva.getFechaFinalizacion())
				.respuesta(reserva.getRespuesta())
				.build();
	}
}
