package co.com.ajac.usercases.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.domain.CommonProperty;
import co.com.ajac.services.common.CommonService;
import common.Query;
import io.vavr.collection.List;

@Component
public class FindAllCommonByHorizontal implements Query<List<CommonProperty>, String>{

	private final CommonService service;

	@Autowired
	public FindAllCommonByHorizontal(CommonService service) {
		this.service = service;
	}



	@Override
	public List<CommonProperty> execute(String nit) {
		return service.findAllCommonByHorizontalProperty(nit);
	}	
}
