package co.com.ajac.services;

import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.entities.usuarios.Credencial;
import co.com.ajac.entities.usuarios.Usuario;
import co.com.ajac.ports.ResidenteRepository;
import co.com.ajac.ports.UsuarioRepository;
import coremodel.datosbasicos.Identificacion;
import io.vavr.control.Option;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	private final ResidenteRepository residenteRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository, ResidenteRepository residenteRepository) {
		this.usuarioRepository = usuarioRepository;
		this.residenteRepository = residenteRepository;
	}
	
	public Usuario registrarUsuario(Usuario usuario){
		log.debug("Validando el registro de un nuevo usuario");
		
		if(residenteRepository.verificarExistenciaDeAlgunaPersonaPorSuIdentificacion(usuario.getIdentificacion())) {
			log.error("Ya existe un usuario en base de datos con esta identificacion: {}", usuario.getIdentificacion());
			throw new BusinessException("Ya existe un usuario en base de datos con esta identificacion");
		}
		
		if(usuarioRepository.obtenerUsuarioPorSuUsername(usuario.getCredencial().getUsername()).isDefined()) {
			log.error("Ya existe en base de datos este usuario con este username: {}", usuario.getCredencial().getUsername());
			throw new BusinessException("Ya existe un usuario agregado con este nombre de usuario");
		}
		log.debug("Se procede a persistir el usuario nuevo");
		return usuarioRepository.registrarUsuario(usuario);
	}
	
	public Option<Usuario> obtenerUsuarioPorSuUSername(String username) {
		return usuarioRepository.obtenerUsuarioPorSuUsername(username);
	}
	
	public Option<Usuario> obtenerUsuarioPorSusCredenciales(Credencial credencial){
		
		return usuarioRepository.obtenerUsuarioPorCredencial(credencial)
				.filter(usuario -> usuario.getCredencial().getPassword().compareTo(credencial.getPassword()) == 0);
	}
	
	public Option<Usuario> obtenerUsuarioPorSusIdentificacion(Identificacion identification){
		
		return usuarioRepository.obtenerUsuarioPorSuIdentificacion(identification);
	}
	

}
