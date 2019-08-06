package coremodel.datosbasicos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class NombreCompleto {
	private final String primerNombre;
	private final String segundoNombre;
	private final String primerApellido;
	private final String segundoApellido;
	
	public String nombreCompleto() {
		return new StringBuilder()
				.append(primerNombre).append(" ")
				.append(segundoNombre).append(" ")
				.append(primerApellido).append(" ")
				.append(segundoApellido).toString();
	}
}
