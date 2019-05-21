package co.com.ajac.usercases.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.domain.CommonProperty;
import co.com.ajac.services.common.CommonService;
import common.Query;
import domain.exceptions.ModelNotFoundException;
import io.vavr.control.Either;

@Component
public class FindOneCommon implements Query<CommonProperty, Integer>{

	private final CommonService service;

	@Autowired
	public FindOneCommon(CommonService service) {
		this.service = service;
	}

	@Override
	public CommonProperty execute(Integer id) {
		Either<String, CommonProperty> eitherResult = service.findOneCommonProperty(id);
		
		return eitherResult.getOrElseThrow(() -> new ModelNotFoundException(eitherResult.getLeft()));
	}
}
