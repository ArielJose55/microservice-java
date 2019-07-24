package co.com.ajac.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.acl.propiedadhorizontal.modelos.PropiedadHorizontalDTO;
import co.com.ajac.queries.PersonQueryResource;
import coremodel.datosbasicos.Identificacion;

@RestController
@RequestMapping("/api/v1")
public class AdministadorEndpoint {

	private final PersonQueryResource personQueryResource;

	@Autowired
	public AdministadorEndpoint(PersonQueryResource personQueryResource) {
		this.personQueryResource = personQueryResource;
	}
	
	@GetMapping("/admin/{tipoId}/{numId}")
	public List<PropiedadHorizontalDTO> obtenerPropiedadesHorizontalesPorAdministrador(@PathVariable("tipoId") String tipoId, @PathVariable("numId") String numId){
		return personQueryResource.obtenerTodasLasPropiedadesHorizontalesPorAdministrador(
				Identificacion.builder()
				.tipoIdentificacion(tipoId)
				.numeroIdentificacion(numId)
				.build())
			.toJavaList();
	}
}
