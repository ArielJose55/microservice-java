package co.com.ajac.enpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.commands.RegistrarPropiedadComunCommand;
import co.com.ajac.dtos.PropiedadComunDTO;
import co.com.ajac.queries.PropiedadComunQuery;

@RestController
@RequestMapping("/property/api/v1")
public class PropiedadComunEndpoint {

	private final RegistrarPropiedadComunCommand registrarPropiedadComunCommand;
	private final PropiedadComunQuery propiedadComunQuery;

	@Autowired
	public PropiedadComunEndpoint(RegistrarPropiedadComunCommand registrarPropiedadComunCommand,
			PropiedadComunQuery propiedadComunQuery) {
		this.registrarPropiedadComunCommand = registrarPropiedadComunCommand;
		this.propiedadComunQuery = propiedadComunQuery;
	}

	@PostMapping("/phs/pcs")
	public void registerHorizontalProperty(@RequestBody PropiedadComunDTO propiedadComunDTO) {
		registrarPropiedadComunCommand.execute(propiedadComunDTO);
	}

	@GetMapping("/phs/pcs/{id}")
	public PropiedadComunDTO getPropiedadComun(@PathVariable("id") Integer idPropiedadComun) {
		return propiedadComunQuery.obtenerPropiedadComunPorSuId(idPropiedadComun);
	}
	
	public void obtenerDispositivosDeUnaPropiedadComun(Integer idPropiedadComun) {
		
	}
	
	/*
	 * @GetMapping("/commons/{id}") public CommonProperty
	 * findOneCommonPropertyById(@PathVariable("id") Integer id) { return
	 * propertyQueryResource.getOneCommonProperty(id); }
	 * 
	 * @GetMapping("{nit}/commons") public List<CommonProperty>
	 * findAllCommonPropertyByHorizontalProperty(@PathVariable("nit") String nit){
	 * return propertyQueryResource.listAllCommonByHorizontalProperty(nit); }
	 */
}
