package co.com.ajac.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ajac.acl.propiedadhorizontal.modelos.PropiedadHorizontalDTO;
import co.com.ajac.queries.UsuarioQuery;
import coremodel.datosbasicos.Identificacion;

@RestController
@RequestMapping("/person/api/v1")
public class AdministadorEndpoint {

	private final UsuarioQuery usuarioQuery;

	@Autowired
	public AdministadorEndpoint(UsuarioQuery usuariiQuery) {
		this.usuarioQuery = usuariiQuery;
	}
	
	@GetMapping("/admin/phs/{tipoId}/{numId}")
	public List<PropiedadHorizontalDTO> obtenerPropiedadesHorizontalesPorAdministrador(@PathVariable("tipoId") String tipoId, @PathVariable("numId") String numId){
		return usuarioQuery.obtenerTodasLasPropiedadesHorizontalesPorAdministrador(
				Identificacion.builder()
				.tipoIdentificacion(tipoId)
				.numeroIdentificacion(numId)
				.build())
			.toJavaList();
	}
	

}
