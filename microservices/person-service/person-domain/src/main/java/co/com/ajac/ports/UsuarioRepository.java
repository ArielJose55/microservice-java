package co.com.ajac.ports;

import java.util.List;

import co.com.ajac.entities.usuarios.Credencial;
import co.com.ajac.entities.usuarios.Usuario;
import coremodel.datosbasicos.Identificacion;
import io.vavr.control.Option;

public interface UsuarioRepository {

	Usuario registrarUsuario(Usuario user);
	
	Option<Usuario> obtenerUsuarioPorCredencial(Credencial credencial);
	
	Option<Usuario> obtenerUsuarioPorSuUsername(String username);
	
	Option<Usuario> obtenerUsuarioPorSuIdentificacion(Identificacion identification);
	
	List<Usuario> obtenerTodosLosUsuarios();
	
	
}
