package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.builders.UsuarioBuilder;
import co.com.ajac.dtos.UsuarioDTO;
import co.com.ajac.services.UsuarioService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class RegistrarUsuarioCommand implements Command<UsuarioDTO>{

	private final UsuarioService usuarioService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public RegistrarUsuarioCommand(UsuarioService usuarioService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioService = usuarioService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public void execute( UsuarioDTO usuarioDTO ) {
		log.info("Ejecutando el comando: RegistrarUsuarioCommand");
		log.debug("Recibiendo el usuario DTO para registrar {}", usuarioDTO);
		
		usuarioDTO.setPassword(bCryptPasswordEncoder.encode(usuarioDTO.getPassword()));
		
		usuarioService.registrarUsuario(UsuarioBuilder.crearUsuarioDesdeDTO(usuarioDTO));
	}
}
