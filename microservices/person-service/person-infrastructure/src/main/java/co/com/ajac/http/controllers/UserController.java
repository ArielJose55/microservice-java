package co.com.ajac.http.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegistrarUsuarioCommand;
import co.com.ajac.dtos.UsuarioDTO;
import co.com.ajac.entities.usuarios.Usuario;
import co.com.ajac.queries.PersonQueryResource;

@CrossOrigin(origins = "http://localhost:3000")	
@RestController
@RequestMapping("/user")
public class UserController {
	
	private final RegistrarUsuarioCommand registerUser;
	
	private final PersonQueryResource personQueryResource;
	
	@Autowired
	public UserController(RegistrarUsuarioCommand registerUser, PersonQueryResource personQueryResource) {
		this.registerUser = registerUser;
		this.personQueryResource = personQueryResource;
	}

	@PostMapping
	public void add(@Valid @RequestBody Usuario user) {
		registerUser.execute(user);
	}
	
	@PostMapping("/login")
	public UsuarioDTO login(@RequestBody Usuario userCredentials) {
		return personQueryResource.login(userCredentials);
	}
	
	@GetMapping("/{id}")
	public Usuario get(@PathVariable("id") String identification) {
		return personQueryResource.findOneUserByIdentification(identification);
	}
	
	@GetMapping("/ph/{id}")
	public List<Usuario> getAll(@PathVariable("id") Integer idPh){
		return null;
	}
}
