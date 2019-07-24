package coremodel.datosbasicos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public final class Identificacion {

	private final String numeroIdentificacion;
	
	private final String tipoIdentificacion;
}
