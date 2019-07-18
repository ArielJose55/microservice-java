package co.com.ajac.services.usuario;

import co.com.ajac.entities.usuarios.Credencial;
import co.com.ajac.entities.usuarios.Usuario;
import co.com.ajac.ports.UsuarioRepository;
import coremodel.excepciones.BusinessException;

public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario registrarUsuario(Usuario usuario){
		
		if(usuarioRepository.obtenerUsuarioPorSuIdentificacion(usuario.getIdentificacion()).isDefined()){
			throw new BusinessException("Ya existe un usuario agregado con esta identificacion");
		}
		
		if(usuarioRepository.obtenerUsuarioPorSuUsername(usuario.getCredencial().getUsername()).isDefined()) {
			throw new BusinessException("Ya existe un usuario agregado con este nombre de usuario");
		}
		
		return usuarioRepository.registrarUsuario(usuario);
	}
	
	public Usuario obtenerUsuarioPorSusCredenciales(Credencial credencial){
		
		
//		Usuario user = userRepository.login(username, password)
//				.orElseThrow(() -> new ModelNotFoundException(INCORRECT_CREDENTIALS));
//		
//		if(user.getState().equals("INACTIVE"))
//			throw new ModelNotFoundException("Usuario inactivo. Por favor, Consulte al administrador");
			
		return null;
	}
	
	
	

}
