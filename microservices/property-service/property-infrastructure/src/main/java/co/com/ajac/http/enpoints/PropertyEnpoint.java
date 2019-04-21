package co.com.ajac.http.enpoints;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.domain.HorizontalProperty;

@RestController
@RequestMapping("/")
public class PropertyEnpoint {

	public HorizontalProperty registerHorizontalProperty(@Valid @RequestBody HorizontalProperty property) {
		
	}
}
