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

import co.com.ajac.commands.RegisterCommonProperty;
import co.com.ajac.domain.cps.CommonProperty;
import co.com.ajac.dtos.CommonPropertyDTO;
import co.com.ajac.queries.PropertyQueryResource;

//@RestController
//@RequestMapping("/")
public class PropiedadComunEndpoint {

	private final RegisterCommonProperty registerCommon;
	
	private final PropertyQueryResource propertyQueryResource;
	
	
	//@Autowired
	public PropiedadComunEndpoint(RegisterCommonProperty registerCommon, PropertyQueryResource propertyQueryResource) {
		this.registerCommon = registerCommon;
		this.propertyQueryResource = propertyQueryResource;
	}

	@PostMapping("/commons")
	public void registerCommonPropety(@Valid @RequestBody CommonPropertyDTO property) {
		registerCommon.execute(property);
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
