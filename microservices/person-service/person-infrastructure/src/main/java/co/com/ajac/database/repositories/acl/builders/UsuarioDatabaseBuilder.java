package co.com.ajac.database.repositories.acl.builders;

import co.com.ajac.database.repositories.personanatural.PersonaNaturalRecord;
import co.com.ajac.database.repositories.usuario.UsuarioRecord;
import co.com.ajac.entities.usuarios.Credencial;
import co.com.ajac.entities.usuarios.EstadoUsuario;
import co.com.ajac.entities.usuarios.TipoUsuario;
import co.com.ajac.entities.usuarios.Usuario;
import coremodel.datosbasicos.Identificacion;
import coremodel.datosbasicos.NombreCompleto;

public class UsuarioDatabaseBuilder {

	private UsuarioDatabaseBuilder() {}
	
	public static UsuarioRecord crearUsuarioRecordDesdeEntidad(Usuario usuario) {
		
		PersonaNaturalRecord personaNaturalRecord = new PersonaNaturalRecord(
				usuario.getIdentificacion().getNumeroIdentificacion(),
				usuario.getIdentificacion().getTipoIdentificacion(),
				usuario.getNombreCompleto().getPrimerNombre(),
				usuario.getNombreCompleto().getSegundoNombre(),
				usuario.getNombreCompleto().getPrimerApellido(),
				usuario.getNombreCompleto().getSegundoApellido());
		
		return new UsuarioRecord(
				personaNaturalRecord,
				usuario.getCredencial().getUsername(),
				usuario.getCredencial().getPassword(),
				usuario.getTipoUsuario().getCodigo(),
				usuario.getEstadoUsuario().getCodigo(),
				null,
				null);
	}
	
	public static Usuario crearUsuarioDesdeRecord(UsuarioRecord usuarioRecord) {
		
		Identificacion identificacion = Identificacion.builder()
				.numeroIdentificacion(usuarioRecord.getPersonaNaturalRecord().getNumeroIdentificacion())
				.tipoIdentificacion(usuarioRecord.getPersonaNaturalRecord().getTipoIdentificacion())
				.build();
		
		NombreCompleto nombreCompleto = NombreCompleto.builder()
				.primerApellido(usuarioRecord.getPersonaNaturalRecord().getPrimerNombre())
				.segundoNombre(usuarioRecord.getPersonaNaturalRecord().getSegundoNombre())
				.primerApellido(usuarioRecord.getPersonaNaturalRecord().getPrimerApellido())
				.segundoApellido(usuarioRecord.getPersonaNaturalRecord().getSegundoApellido())
				.build();
		
		Credencial credencial = Credencial.builder()
				.username(usuarioRecord.getUsername())
				.password(usuarioRecord.getPassword())
				.build();
		
		return Usuario.builder()
				.identificacion(identificacion)
				.nombreCompleto(nombreCompleto)
				.credencial(credencial)
				.fechaFinalizacion(usuarioRecord.getFechaRegistro().toLocalDateTime())
				.fechaFinalizacion(usuarioRecord.getFechaFinalizacion() != null? usuarioRecord.getFechaFinalizacion().toLocalDateTime() : null)
				.tipoUsuario(TipoUsuario.obtenerTipoUsuarioDesdeCodigo(usuarioRecord.getTipoUsuario()))
				.estadoUsuario(EstadoUsuario.obtenerEstadoUsuarioDesdeCodigo(usuarioRecord.getEstadoUsuario()))
				.build();
	}
}
