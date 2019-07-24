package co.com.ajac.database.repositories.personanatural;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class PersonaNaturalRecord {

	private final String numeroIdentificacion;
	private final String tipoIdentificacion;
	private final String primerNombre;
	private final String segundoNombre;
	private final String primerApellido;
	private final String segundoApellido;
}
