package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.acl.builders.UsuarioBuilder;
import co.com.ajac.dtos.UsuarioDTO;
import co.com.ajac.services.usuario.UsuarioService;
import commands.Command;


@Component
public class RegistrarUsuarioCommand implements Command<UsuarioDTO>{

	private final UsuarioService usuarioService;

	@Autowired
	public RegistrarUsuarioCommand(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
	public void execute( UsuarioDTO usuarioDTO ) {
		
		usuarioService.registrarUsuario(UsuarioBuilder.crearUsuarioDesdeDTO(usuarioDTO));
	}
}
