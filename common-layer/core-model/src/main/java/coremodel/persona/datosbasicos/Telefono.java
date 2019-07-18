package coremodel.persona.datosbasicos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Telefono {

	private final String numeroDeTelefono;
	private final Boolean preferencial;
	private final String indicativo;
	private final TipoTelefono tipoTelefono;
}
