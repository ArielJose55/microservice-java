package co.com.ajac.http.enpoints;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegisterHorizontalProperty;
import co.com.ajac.domain.HorizontalProperty;

@RestController
@RequestMapping("/")
public class PropertyEnpoint {

	@Autowired
	private RegisterHorizontalProperty registerHorizontal;
	
	
	@PostMapping("/horizontals")
	public void registerHorizontalProperty(@Valid @RequestBody HorizontalProperty property) {
		registerHorizontal.execute(property);
	}
}
