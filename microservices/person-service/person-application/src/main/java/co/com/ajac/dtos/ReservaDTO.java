package co.com.ajac.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

	private Integer idReserva;
	private String descripcion;
	private String respuesta;
	private String estadoReserva;
	private LocalDateTime fechaInicio;	
	private LocalDateTime fechaFinalizacion;
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	private Integer idBienComun;
	private ResidenteDTO residente;
	private HabitanteDTO habitante;
}
