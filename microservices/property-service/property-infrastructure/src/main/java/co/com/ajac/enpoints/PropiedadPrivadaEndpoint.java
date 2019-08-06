package co.com.ajac.enpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegistrarPropiedadPrivadaCommand;
import co.com.ajac.dtos.PropiedadComunDTO;
import co.com.ajac.dtos.PropiedadPrivadaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/property/api/v1")
@Api("Endpint para la gestion de propiedades horizontales")
public class PropiedadPrivadaEndpoint {

	private final RegistrarPropiedadPrivadaCommand propiedadPrivadaCommand;

	@Autowired
	public PropiedadPrivadaEndpoint(RegistrarPropiedadPrivadaCommand propiedadPrivadaCommand) {
		this.propiedadPrivadaCommand = propiedadPrivadaCommand;
	}
	
	@PostMapping("/phs/pps")
	@ApiOperation(value = "registra una pripiedad horizontal", code = 200, httpMethod = "POST")
	public void registerHorizontalProperty(@RequestBody PropiedadPrivadaDTO propiedadPrivadaDTO) {
		propiedadPrivadaCommand.execute(propiedadPrivadaDTO);
	}

}
