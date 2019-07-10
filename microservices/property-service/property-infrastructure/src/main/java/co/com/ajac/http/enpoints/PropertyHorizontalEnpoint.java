package co.com.ajac.http.enpoints;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegisterHorizontalProperty;
import co.com.ajac.domain.HorizontalProperty;
import co.com.ajac.dtos.HorizontalPropertyDTO;
import co.com.ajac.queries.PropertyQueryResource;

@RestController
@RequestMapping("/")
public class PropertyHorizontalEnpoint {

	private final PropertyQueryResource propertyQueryResource;
	private final RegisterHorizontalProperty registerHorizontal;
	
	@Autowired
	public PropertyHorizontalEnpoint(PropertyQueryResource propertyQueryResource,
			RegisterHorizontalProperty registerHorizontal) {
		this.propertyQueryResource = propertyQueryResource;
		this.registerHorizontal = registerHorizontal;
	}

	@PostMapping("/horizontals")
	public void registerHorizontalProperty(@Valid @RequestBody HorizontalProperty property) {
		registerHorizontal.execute(property);
	}
	
	@GetMapping("/horizontals/admin/{admin}")
	public List<HorizontalPropertyDTO> findAllHorizontalPropertyByAdmin(@PathVariable("admin") String identification){
		return propertyQueryResource.listAllPropetyByAdministrator(identification);
	}
}
