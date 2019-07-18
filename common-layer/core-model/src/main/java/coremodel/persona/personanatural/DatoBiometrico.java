package coremodel.persona.personanatural;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class DatoBiometrico {

	private final String plantilla;
	
	private final String codigoDeSeguridad;
}
