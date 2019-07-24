package co.com.ajac.database.repositories.usuario;

import java.sql.Timestamp;

import co.com.ajac.database.repositories.personanatural.PersonaNaturalRecord;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class UsuarioRecord {

	private final PersonaNaturalRecord personaNaturalRecord;
	private final String username;
	private final String password;
	private final String tipoUsuario;
	private final String estadoUsuario;
	private final Timestamp fechaRegistro;
	private final Timestamp fechaFinalizacion;
}
