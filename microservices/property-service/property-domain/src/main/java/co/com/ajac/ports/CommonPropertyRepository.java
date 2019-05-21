package co.com.ajac.ports;

import co.com.ajac.domain.CommonProperty;
import io.vavr.collection.List;
import io.vavr.control.Option;

public interface CommonPropertyRepository {

	List<CommonProperty> findAllCommonPropertyBy(String nitHorizontalProperty);
	
	Option<Integer> registerCommonProperty(CommonProperty property);
	
	Option<CommonProperty> findOneCommonProperty(Integer id);
}
