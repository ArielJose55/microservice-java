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

import co.com.ajac.commands.RegisterUserCommand;
import co.com.ajac.dtos.UserDTO;
import co.com.ajac.models.User;
import co.com.ajac.queries.PersonQueryResource;

@CrossOrigin(origins = "http://localhost:3000")	
@RestController
@RequestMapping("/user")
public class UserController {
	
	private final RegisterUserCommand registerUser;
	
	private final PersonQueryResource personQueryResource;
	
	@Autowired
	public UserController(RegisterUserCommand registerUser, PersonQueryResource personQueryResource) {
		this.registerUser = registerUser;
		this.personQueryResource = personQueryResource;
	}

	@PostMapping
	public void add(@Valid @RequestBody User user) {
		registerUser.execute(user);
	}
	
	@PostMapping("/login")
	public UserDTO login(@RequestBody User userCredentials) {
		return personQueryResource.login(userCredentials);
	}
	
	@GetMapping("/{id}")
	public User get(@PathVariable("id") String identification) {
		return personQueryResource.findOneUserByIdentification(identification);
	}
	
	@GetMapping("/ph/{id}")
	public List<User> getAll(@PathVariable("id") Integer idPh){
		return null;
	}
}
