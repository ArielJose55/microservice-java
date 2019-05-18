package co.com.ajac.services;

import co.com.ajac.domain.HorizontalProperty;
import co.com.ajac.ports.PropertyRespository;
import io.vavr.control.Option;

public class PropertyService {

	private final PropertyRespository propertyRespository;

	public PropertyService(PropertyRespository propertyRespository) {
		this.propertyRespository = propertyRespository;
	}
	
	public Option<Integer> registerHorizontalProperty(HorizontalProperty property) {
		return propertyRespository.registerHorizontalProperty(property);
	}
}
