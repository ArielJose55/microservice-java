package co.com.ajac.services;

import java.util.Optional;

import co.com.ajac.domain.HorizontalProperty;
import co.com.ajac.ports.PropertyRespository;

public class PropertyService {

	private final PropertyRespository propertyRespository;

	public PropertyService(PropertyRespository propertyRespository) {
		this.propertyRespository = propertyRespository;
	}
	
	public Optional<HorizontalProperty> register(HorizontalProperty property) {
		return propertyRespository.register(property);
	}
}
