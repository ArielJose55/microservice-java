package co.com.ajac.entities.visitante;

import coremodel.datosbasicos.Identificacion;
import coremodel.datosbasicos.NombreCompleto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class Visitante {

	private final Identificacion identificacion;
	
	private final NombreCompleto nombreCompleto;
	
	
}
