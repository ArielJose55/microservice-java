package co.com.ajac.ports.repositories;

import co.com.ajac.domain.HorizontalProperty;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface HorizontalPropertyRespository {

	Option<String> registerHorizontalProperty(HorizontalProperty horizontalProperty);
	
	Option<String> findOneHorizonalProperty(String id);
	
	List<HorizontalProperty> listAllHorizontalProperty(String identification);

}
