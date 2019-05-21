package co.com.ajac.ports;

import co.com.ajac.domain.HorizontalProperty;
import io.vavr.control.Option;

public interface PropertyRespository {

	Option<String> registerHorizontalProperty(HorizontalProperty horizontalProperty);
	
	Option<String> findOneHorizonalProperty(String id);

}
