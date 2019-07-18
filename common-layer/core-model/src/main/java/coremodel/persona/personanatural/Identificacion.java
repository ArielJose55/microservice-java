package coremodel.persona.personanatural;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public final class Identificacion {

	private final String numeroIdentificacion;
	
	private final String tipoIdentificacion;
}
