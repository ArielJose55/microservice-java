package co.com.ajac.acl.builders;

import co.com.ajac.dtos.UsuarioDTO;
import co.com.ajac.entities.usuarios.Credencial;
import co.com.ajac.entities.usuarios.EstadoUsuario;
import co.com.ajac.entities.usuarios.TipoUsuario;
import co.com.ajac.entities.usuarios.Usuario;
import coremodel.persona.datosbasicos.NombreCompleto;
import coremodel.persona.personanatural.Identificacion;

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
				.primerApellido(usuarioDTO.getPrimerNombre())
				.segundoNombre(usuarioDTO.getSegundoNombre())
				.primerApellido(usuarioDTO.getPrimerApellido())
				.segundoApellido(usuarioDTO.getSegundoApellido())
				.build();
		
		return Usuario.builder()
				.credencial(credencial)
				.identificacion(identificacion)
				.nombreCompleto(nombreCompleto)
				.estadoUsuario(null)
				.tipoUsuario(TipoUsuario.obtenerTipoUsuarioDesdeCodigo(usuarioDTO.getTipoUsuario()))
				.build();
	}

}
