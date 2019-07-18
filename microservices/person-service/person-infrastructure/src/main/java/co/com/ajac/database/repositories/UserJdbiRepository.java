package co.com.ajac.database.repositories;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ajac.entities.usuarios.Usuario;
import lombok.Cleanup;


@Repository
public class UserJdbiRepository {

	@Autowired
	private Jdbi jdbi;

	public Optional<Usuario> create(Usuario user) {
		
		@Cleanup
		Handle handle = jdbi.open();
		return handle.createUpdate(
				"INSERT INTO \"USER\"(person_fk, username, password) VALUES (:identification, :username, :password)")
				.bindBean(user)
				.executeAndReturnGeneratedKeys()
				.mapToBean(Usuario.class)
				.findFirst();
	}

	public Optional<Usuario> login(String username, String password) {
		
		@Cleanup
		Handle handle = jdbi.open();
		return handle.createQuery("SELECT * FROM \"USER\" WHERE username = :username AND password = :password")
				.bind("username", username)
				.bind("password", password)
				.mapToBean(Usuario.class)
				.findFirst();
	}
	

	public Optional<Usuario> get(String identification) {
		
		@Cleanup
		Handle handle = jdbi.open();
		return handle.createQuery("SELECT p.identification,p.\"typeIdentification\" ,u.person_fk, u.username, u.\"password\", u.register_date, u.state  FROM \"USER\" u JOIN \"PERSON\" p ON u.person_fk = p.identification WHERE u.person_fk = :identification")
				.bind("identification", identification)
				.mapToBean(Usuario.class)
				.findFirst();
	}

	
	public Optional<List<Usuario>> findUserActives(){
		
		@Cleanup
		Handle handle = jdbi.open();
		return Optional.ofNullable(handle.createQuery("SELECT  u.username, u.password, u.register_date, u.state, p.identification, p.\"typeIdentification\"\n" + 
				" FROM \"USER\" u JOIN \"PERSON\" p ON u.person_fk = p.identification WHERE u.state = 'ACTIVE'")
				.mapToBean(Usuario.class)
				.list());
	}
}
