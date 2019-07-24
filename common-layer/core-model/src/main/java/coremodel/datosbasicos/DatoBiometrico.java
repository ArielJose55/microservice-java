package coremodel.datosbasicos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class DatoBiometrico {

	private final String plantilla;
	
	private final String codigoDeSeguridad;
}
