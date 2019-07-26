package co.com.ajac.acl.builders;
import co.com.ajac.domain.propiedadeshorizontales.Administrador;
import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import co.com.ajac.dtos.PropiedadHorizontalDTO;
import io.vavr.collection.List;

public class PropiedadHorizontalBuilder {
	
	private PropiedadHorizontalBuilder() {}
	
	public static PropiedadHorizontal crearPropiedadHorizontalDesdeDTO(PropiedadHorizontalDTO propiedadHorizontalDTO) {
		
		Administrador administrador = new Administrador(
				propiedadHorizontalDTO.getTipoId(),
				propiedadHorizontalDTO.getNumId());
		
		return  PropiedadHorizontal.builder()
			.nit(propiedadHorizontalDTO.getNit())
			.administrador(administrador)
			.nombreDistintivo(propiedadHorizontalDTO.getNombreDistintivo())
			.bienesCommunes(List.empty())
			.bienesPrivados(List.empty())
			.build();									
	}
	
	public static PropiedadHorizontalDTO crearPropiedadHorizontalDTODesdeEntidad(PropiedadHorizontal propiedadHorizontal) {
		return PropiedadHorizontalDTO.builder()
				.nit(propiedadHorizontal.getNit())
				.numId(propiedadHorizontal.getAdministrador().getNumeroIdentificacion())
				.tipoId(propiedadHorizontal.getAdministrador().getTipoIdentificacion())
				.nombreDistintivo(propiedadHorizontal.getNombreDistintivo())
				.objetoSocial("")
				.razonSocial("")
				.build();
	}
	
}
