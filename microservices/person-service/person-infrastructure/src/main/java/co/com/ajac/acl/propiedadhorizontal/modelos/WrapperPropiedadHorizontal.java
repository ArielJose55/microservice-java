package co.com.ajac.acl.propiedadhorizontal.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WrapperPropiedadHorizontal {

	private final List<PropiedadHorizontalDTO> propiedades;

	public WrapperPropiedadHorizontal() {
		this.propiedades = new ArrayList<>();
	}	
}
