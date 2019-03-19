package co.com.ajac.http.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FingerprintController {

	@GetMapping
	public String hello(){
		return "hello";
	}
}
