package co.com.ajac.acl.builders;

import co.com.ajac.dtos.UsuarioDTO;
import co.com.ajac.entities.usuarios.Credencial;
import co.com.ajac.entities.usuarios.EstadoUsuario;
import co.com.ajac.entities.usuarios.TipoUsuario;
import co.com.ajac.entities.usuarios.Usuario;
import coremodel.datosbasicos.Identificacion;
import coremodel.datosbasicos.NombreCompleto;

public class UsuarioBuilder {
	
	private UsuarioBuilder() {
		
	}
	
	public static Usuario crearUsuarioDesdeDTO(UsuarioDTO usuarioDTO) {
		
		Credencial credencial = Credencial.builder()
				.username(usuarioDTO.getUsername())
				.password(usuarioDTO.getPassword())
				.build();
		
		Identificacion identificacion = Identificacion.builder()
				.numeroIdentificacion(usuarioDTO.getNumeroIdentificacion())
				.tipoIdentificacion(usuarioDTO.getTipoIdentificacion())
				.build();
		
		NombreCompleto nombreCompleto = NombreCompleto.builder()
				.primerNombre(usuarioDTO.getPrimerNombre())
				.segundoNombre(usuarioDTO.getSegundoNombre())
				.primerApellido(usuarioDTO.getPrimerApellido())
				.segundoApellido(usuarioDTO.getSegundoApellido())
				.build();
		
		return Usuario.builder()
				.credencial(credencial)
				.identificacion(identificacion)
				.nombreCompleto(nombreCompleto)
				.estadoUsuario(
						usuarioDTO.getEstadoUsuario() == null ? EstadoUsuario.ACTIVO :
							EstadoUsuario.obtenerEstadoUsuarioDesdeCodigo(usuarioDTO.getEstadoUsuario()))
				.tipoUsuario(TipoUsuario.obtenerTipoUsuarioDesdeCodigo(usuarioDTO.getTipoUsuario()))
				.build();
	}
	
	public static UsuarioDTO crearUsuarioDTODesdeEntidad(Usuario usuario) {
		
		return UsuarioDTO.builder()
				.numeroIdentificacion(usuario.getIdentificacion().getNumeroIdentificacion())
				.tipoIdentificacion(usuario.getIdentificacion().getTipoIdentificacion())
				.primerNombre(usuario.getNombreCompleto().getPrimerNombre())
				.segundoNombre(usuario.getNombreCompleto().getSegundoNombre())
				.primerApellido(usuario.getNombreCompleto().getPrimerApellido())
				.segundoApellido(usuario.getNombreCompleto().getSegundoApellido())
				.nombreCompleto(usuario.getNombreCompleto().nombreCompleto())
				.estadoUsuario(usuario.getEstadoUsuario().getCodigo())
				.tipoUsuario(usuario.getTipoUsuario().getCodigo())
				.username(usuario.getCredencial().getUsername())
				.password(usuario.getCredencial().getPassword())
				.build();
	}

}
