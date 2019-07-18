package coremodel.persona.personanatural;

import coremodel.persona.datosbasicos.CorreoElectronico;
import coremodel.persona.datosbasicos.Direccion;
import coremodel.persona.datosbasicos.Telefono;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@Builder
@RequiredArgsConstructor
public class PersonaNatural {
	
	protected final Identificacion identificacion;
	
	protected final Direccion direccion;
	
	protected final CorreoElectronico correoElectronico;
	
	protected final Telefono telefono;

	protected final String primerNombre;

	protected final String segundoNombre;
	
	protected final String primerApellido;
	
	protected final String segundoApellido;
	
	protected final DatoBiometrico datoBiometrico;
	

	public String nombreCompleto() {
		return new StringBuilder()
				.append(primerApellido).append(" ")
				.append(segundoApellido).append(" ")
				.append(primerApellido).append(" ")
				.append(segundoApellido).toString();
	}
}
