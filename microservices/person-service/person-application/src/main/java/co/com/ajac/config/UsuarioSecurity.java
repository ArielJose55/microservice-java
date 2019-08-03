package co.com.ajac.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.entities.usuarios.Usuario;
import co.com.ajac.services.UsuarioService;

@Component
public class UsuarioSecurity implements UserDetailsService{

	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioSecurity(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioService.obtenerUsuarioPorSuUSername(username)
			.getOrElseThrow(() -> new BusinessException("Usuario no registrado"));

		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(usuario.getTipoUsuario().getCodigo()));
		
		UserDetails userDet = new User(
				usuario.getCredencial().getUsername(),
				usuario.getCredencial().getPassword(),
				roles);
		
		return userDet;
	}

}
