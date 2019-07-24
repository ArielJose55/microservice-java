package co.com.ajac.services;

import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.entities.usuarios.Credencial;
import co.com.ajac.entities.usuarios.Usuario;
import co.com.ajac.ports.UsuarioRepository;
import coremodel.datosbasicos.Identificacion;
import io.vavr.control.Option;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario registrarUsuario(Usuario usuario){
		log.debug("Validando el registro de un nuevo usuario");
		if(usuarioRepository.obtenerUsuarioPorSuIdentificacion(usuario.getIdentificacion()).isDefined()){
			log.error("Ya existe en base de datos este usuario: {}", usuario.getIdentificacion());
			throw new BusinessException("Ya existe un usuario agregado con esta identificacion");
		}
		
		if(usuarioRepository.obtenerUsuarioPorSuUsername(usuario.getCredencial().getUsername()).isDefined()) {
			log.error("Ya existe en base de datos este usuario con este username: {}", usuario.getCredencial().getUsername());
			throw new BusinessException("Ya existe un usuario agregado con este nombre de usuario");
		}
		log.debug("Se procede a persistir el usuario nuevo");
		return usuarioRepository.registrarUsuario(usuario);
	}
	
	public Option<Usuario> obtenerUsuarioPorSusCredenciales(Credencial credencial){
		
		return usuarioRepository.obtenerUsuarioPorCredencial(credencial)
				.filter(usuario -> usuario.getCredencial().getPassword().compareTo(credencial.getPassword()) == 0);
	}
	
	public Option<Usuario> obtenerUsuarioPorSusIdentificacion(Identificacion identification){
		
		return usuarioRepository.obtenerUsuarioPorSuIdentificacion(identification);
	}
	

}
