package co.com.ajac.entities.visitante;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@RequiredArgsConstructor
public class Visita {

	private final Visitante visitante;
	
	private final TipoVisita visita;
	
	private final LocalDateTime fechaIngreso;
	
	private final LocalDateTime fechaSalida;
	
	private final Integer propiedadPrivada;
	
	private final TipoIngreso tipoIngreso;
}
