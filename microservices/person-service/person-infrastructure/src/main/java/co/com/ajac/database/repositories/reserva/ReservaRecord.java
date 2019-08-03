package co.com.ajac.database.repositories.reserva;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReservaRecord {
	
	private final Integer idReserva;
	private final String descripcion;
	private final String estadoReserva;
	private final Timestamp fechaInicio;
	private final Timestamp fechaFinalizacion;
	private final Integer bienComun;
	private final String tipoIdentificacion;
	private final String numeroIdentificacion;
}
