package co.com.ajac.usercases.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.domain.CommonProperty;
import co.com.ajac.services.common.CommonService;
import common.Query;
import domain.exceptions.NotSaveModelException;
import io.vavr.control.Either;
import io.vavr.control.Option;

@Component
public class RegisterCommon implements Query<Integer, CommonProperty>{

	private final CommonService service;
	
	@Autowired
	public RegisterCommon(CommonService service) {
		this.service = service;
	}

	@Override
	public Integer execute(CommonProperty property) {
	
		Either<String, Option<Integer>> eitherResult = service.registerCommonProperty(property);
		
		System.out.println(eitherResult);
		return  eitherResult.getOrElseThrow(
				() -> new NotSaveModelException(eitherResult.getLeft()))
				.getOrElseThrow(() -> new NotSaveModelException("Oups! No fue posible registrar este bien comun"));
	}
}
