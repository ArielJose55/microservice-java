package co.com.ajac.entities.residentes.reservas;

import java.time.LocalDateTime;

import coremodel.datosbasicos.Identificacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reserva {

	private String idReserva;
	
	private String descripcion;
	
	private String respuesta;
	
	private EstadoReserva estadoReserva;
	
	private LocalDateTime fechaInicio;
	
	private LocalDateTime fechaFinalizacion;
	
	private Integer bienComun;
	
	private Identificacion identificacion;
}
