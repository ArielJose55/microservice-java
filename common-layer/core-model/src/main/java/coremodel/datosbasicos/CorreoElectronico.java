package coremodel.datosbasicos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@Builder
@RequiredArgsConstructor
public class CorreoElectronico {

	private final String correo;
	
	private final Boolean preferencial;
}
