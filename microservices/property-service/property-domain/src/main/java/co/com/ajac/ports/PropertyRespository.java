package co.com.ajac.ports;

import java.util.Optional;

import co.com.ajac.domain.HorizontalProperty;

public interface PropertyRespository {

	public Optional<HorizontalProperty> register(HorizontalProperty horizontalProperty);
	
	public Optional<HorizontalProperty> findOne(Integer id);
	
	public Optional<HorizontalProperty> fidnOneWithAttributes(Integer id);
}
