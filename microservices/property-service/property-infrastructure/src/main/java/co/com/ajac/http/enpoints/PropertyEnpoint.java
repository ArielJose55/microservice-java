package co.com.ajac.http.enpoints;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.domain.HorizontalProperty;
import co.com.ajac.usercases.hotizontal.RegisterHorizontal;

@RestController
@RequestMapping("/")
public class PropertyEnpoint {

	@Autowired
	private RegisterHorizontal registerHorizontal;
	
	@PostMapping("/horizontal")
	public String registerHorizontalProperty(@Valid @RequestBody HorizontalProperty property) {
		return registerHorizontal.execute(property);
	}
}
