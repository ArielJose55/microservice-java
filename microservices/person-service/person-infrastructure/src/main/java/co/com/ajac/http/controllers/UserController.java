package co.com.ajac.http.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.models.User;
import co.com.ajac.usecase.user.GetAllUser;
import co.com.ajac.usecase.user.GetUser;
import co.com.ajac.usecase.user.LoginUser;
import co.com.ajac.usecase.user.RegisterUser;


@RestController
@RequestMapping("/user")
public class UserController {
	
	private final RegisterUser registerUser;
	
	private final LoginUser loginUser;
	
	private final GetUser getUser;
	
	private final GetAllUser getAllUser;
	
	@Autowired
	public UserController(RegisterUser registerUser, LoginUser loginUser, GetUser getUser, GetAllUser getAllUser) {
		this.registerUser = registerUser;
		this.loginUser = loginUser;
		this.getUser = getUser;
		this.getAllUser = getAllUser;
	}

	@PostMapping
	public User add(@Valid @RequestBody User user) {
		return registerUser.execute(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestParam String username, @RequestParam String password) {
		Map<String, String> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);
		return loginUser.execute(params);
	}
	
	@GetMapping("/{id}")
	public User get(@PathVariable("id") String identification) {
		return getUser.execute(identification);
	}
	
	@GetMapping
	public List<User> getAll(){
		return getAllUser.execute();
	}
}
