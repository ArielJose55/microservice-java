package co.com.ajac.database.repositories;

import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.database.repositories.acl.builders.UsuarioDatabaseBuilder;
import co.com.ajac.database.repositories.transacciones.PersonaRepositoryTransaction;
import co.com.ajac.database.repositories.usuario.UsuarioDAO;
import co.com.ajac.entities.usuarios.Credencial;
import co.com.ajac.entities.usuarios.Usuario;
import co.com.ajac.ports.UsuarioRepository;
import coremodel.datosbasicos.Identificacion;
import io.vavr.control.Option;

@Repository
public class UsuarioJdbiRepository implements UsuarioRepository{

	private final PersonaRepositoryTransaction personaRepositoryTransaction;
	private final UsuarioDAO usuarioDAO;
	
	@Autowired
	public UsuarioJdbiRepository(Jdbi jdbi) {
		this.personaRepositoryTransaction = jdbi.onDemand(PersonaRepositoryTransaction.class);
		this.usuarioDAO = jdbi.onDemand(UsuarioDAO.class);
	}
	
	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		personaRepositoryTransaction.guardarUsuarioCompleto(
				UsuarioDatabaseBuilder.crearUsuarioRecordDesdeEntidad(usuario));
		return usuario;
	}

	@Override
	public Option<Usuario> obtenerUsuarioPorCredencial (Credencial credencial) {
		return usuarioDAO.obtenerUsuarioPorUsername(credencial.getUsername())
				.map(UsuarioDatabaseBuilder::crearUsuarioDesdeRecord);
	}

	@Override
	public Option<Usuario> obtenerUsuarioPorSuUsername(String username) {
		return usuarioDAO.obtenerUsuarioPorUsername(username)
				.map(UsuarioDatabaseBuilder::crearUsuarioDesdeRecord);
	}

	@Override
	public Option<Usuario> obtenerUsuarioPorSuIdentificacion(Identificacion identification) {
		return usuarioDAO.obtenerUsuarioPorSuIdentificacion(
				identification.getTipoIdentificacion(),
				identification.getNumeroIdentificacion())
			.map(UsuarioDatabaseBuilder::crearUsuarioDesdeRecord);
	}

	@Override
	public List<Usuario> obtenerTodosLosUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
