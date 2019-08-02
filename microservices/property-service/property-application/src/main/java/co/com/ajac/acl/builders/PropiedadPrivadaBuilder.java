package co.com.ajac.acl.builders;

import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import co.com.ajac.domain.propiedadeshorizontales.propiedadesprivadas.PropiedadPrivada;
import co.com.ajac.dtos.PropiedadPrivadaDTO;

public class PropiedadPrivadaBuilder {

	private PropiedadPrivadaBuilder() {}
	
	public static PropiedadPrivada crearPropiedadPrivadaDesdeDTO(PropiedadHorizontal propiedadHorizontal, PropiedadPrivadaDTO propiedadPrivadaDTO) {
		return PropiedadPrivada.builder()
				.idPropiedadPrivada(propiedadPrivadaDTO.getId() == null || propiedadHorizontal.getNit().compareTo("") == 0 ?
						null : propiedadPrivadaDTO.getId())
				.propiedadHorizontal(propiedadHorizontal)
				.ubicacion(propiedadPrivadaDTO.getUbicacion())
				.build();
	}
	
	public static PropiedadPrivadaDTO crearPropiedadPrivadaDTODesdeEntidad(PropiedadPrivada propiedadPrivada) {
		return PropiedadPrivadaDTO.builder()
				.id(propiedadPrivada.getIdPropiedadPrivada())
				.ubicacion(propiedadPrivada.getUbicacion())
				.residentes(propiedadPrivada.getResidentes().asJava())
				.build();
	}
}
