package co.com.ajac.acl.builders;

import co.com.ajac.domain.propiedadeshorizontales.PropiedadHorizontal;
import co.com.ajac.domain.propiedadeshorizontales.propiedadescomunes.PropiedadComun;
import co.com.ajac.dtos.PropiedadComunDTO;

public class PropiedadComunBuilder {

	private PropiedadComunBuilder() {}
	
	public static PropiedadComunDTO crearPropiedadComunDTODesdeEntidad(PropiedadComun propiedadComun) {
		
		return PropiedadComunDTO.builder()
				.id(propiedadComun.getIdPropiedadComun())
				.nombre(propiedadComun.getNombre())
				.esencial(propiedadComun.getEsencial())
				.dispositivos(propiedadComun.getDispositivos().toJavaList())
				.build();
	}
	
	public static PropiedadComun crearPropiedadCommunDesdeDTO(PropiedadHorizontal propiedadHorizontal,PropiedadComunDTO propiedadComunDTO) {
		
		return PropiedadComun.builder()
				.idPropiedadComun(null)
				.nombre(propiedadComunDTO.getNombre())
				.esencial(propiedadComunDTO.getEsencial())
				.propiedadHorizontal(propiedadHorizontal)
				.build();
	}
}
