package co.com.ajac.enpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegistrarPropiedadHorizontalCommand;
import co.com.ajac.domain.propiedadeshorizontales.Administrador;
import co.com.ajac.dtos.PropiedadHorizontalDTO;
import co.com.ajac.queries.PropiedadHorizontalQuery;

@RestController
@RequestMapping("/property/api/v1")
public class PropiedadHorizontalEnpoint {

	private final PropiedadHorizontalQuery propiedadHorizontalQuery;
	private final RegistrarPropiedadHorizontalCommand registerHorizontal;
	
	@Autowired
	public PropiedadHorizontalEnpoint(PropiedadHorizontalQuery propiedadHorizontalQuery,
			RegistrarPropiedadHorizontalCommand registerHorizontal) {
		this.propiedadHorizontalQuery = propiedadHorizontalQuery;
		this.registerHorizontal = registerHorizontal;
	}

	@PostMapping("/phs")
	public void registerHorizontalProperty(@RequestBody PropiedadHorizontalDTO property) {
		registerHorizontal.execute(property);
	}
	
	
	@GetMapping("/phs/admin/{tipoId}/{numId}")
	public List<PropiedadHorizontalDTO> findAllHorizontalPropertyByAdmin(@PathVariable("tipoId") String tipoId, @PathVariable("numId") String numId){
		return propiedadHorizontalQuery.listarPropiedadesHorizontalesDeUnAdministrador(new Administrador(tipoId, numId))
				.asJava();
	}
	
	@GetMapping("/phs/{nit}")
	public PropiedadHorizontalDTO obtenerPropiedadHorizontalPorNit(@PathVariable("nit") String nit){
		return propiedadHorizontalQuery.obtenerPropiedadHorizontalPorNit(nit);
	}
}
