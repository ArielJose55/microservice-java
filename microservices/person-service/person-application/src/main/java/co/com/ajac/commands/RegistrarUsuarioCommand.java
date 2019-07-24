package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.builders.UsuarioBuilder;
import co.com.ajac.dtos.UsuarioDTO;
import co.com.ajac.services.UsuarioService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class RegistrarUsuarioCommand implements Command<UsuarioDTO>{

	private final UsuarioService usuarioService;

	@Autowired
	public RegistrarUsuarioCommand(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
	public void execute( UsuarioDTO usuarioDTO ) {
		log.debug("Recibiendo el usuario DTO para registrar {}", usuarioDTO);
		
		
		usuarioService.registrarUsuario(UsuarioBuilder.crearUsuarioDesdeDTO(usuarioDTO));
	}
}
