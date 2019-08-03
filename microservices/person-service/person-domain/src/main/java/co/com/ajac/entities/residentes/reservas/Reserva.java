package co.com.ajac.entities.residentes.reservas;

import java.time.LocalDateTime;

import coremodel.datosbasicos.Identificacion;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class Reserva {

	private final Integer idReserva;
	
	private final String descripcion;
	
	private final String respuesta;
	
	private final EstadoReserva estadoReserva;
	
	private final LocalDateTime fechaInicio;
	
	private final LocalDateTime fechaFinalizacion;
	
	private final Integer bienComun;
	
	private final Identificacion identificacion;
}
