package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.domain.CommonProperty;
import co.com.ajac.services.common.CommonService;
import common.Command;
import domain.exceptions.NotSaveModelException;
import io.vavr.control.Either;
import io.vavr.control.Option;

@Component
public class RegisterCommonProperty implements Command<CommonProperty>{

	private final CommonService service;
	
	@Autowired
	public RegisterCommonProperty(CommonService service) {
		this.service = service;
	}

	@Override
	public void execute(CommonProperty property) {
	
		Either<String, Option<Integer>> eitherResult = service.registerCommonProperty(property);		
		eitherResult.getOrElseThrow(
				() -> new NotSaveModelException(eitherResult.getLeft()))
				.getOrElseThrow(() -> new NotSaveModelException("Oups! No fue posible registrar este bien comun"));
	}
}
