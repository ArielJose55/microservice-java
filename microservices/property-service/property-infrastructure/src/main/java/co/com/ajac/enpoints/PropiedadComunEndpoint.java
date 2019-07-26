package co.com.ajac.enpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegistrarPropiedadComunCommand;
import co.com.ajac.dtos.PropiedadComunDTO;
import co.com.ajac.queries.PropertyQueryResource;

@RestController
@RequestMapping("/property/api/v1")
public class PropiedadComunEndpoint {

	private final RegistrarPropiedadComunCommand registrarPropiedadComunCommand;	
	private final PropertyQueryResource propertyQueryResource;
	
	
	@Autowired
	public PropiedadComunEndpoint(
			RegistrarPropiedadComunCommand registrarPropiedadComunCommand,
			PropertyQueryResource propertyQueryResource) {
		this.registrarPropiedadComunCommand = registrarPropiedadComunCommand;
		this.propertyQueryResource = propertyQueryResource;
	}

	@PostMapping("/phs/pcs")
	public void registerHorizontalProperty(@RequestBody PropiedadComunDTO propiedadComunDTO) {
		registrarPropiedadComunCommand.execute(propiedadComunDTO);
	}
	
	/*
	@GetMapping("/commons/{id}")
	public CommonProperty findOneCommonPropertyById(@PathVariable("id") Integer id) {
		return propertyQueryResource.getOneCommonProperty(id);
	}
	
	@GetMapping("{nit}/commons")
	public List<CommonProperty> findAllCommonPropertyByHorizontalProperty(@PathVariable("nit") String nit){
		return propertyQueryResource.listAllCommonByHorizontalProperty(nit);
	}
	*/
}
