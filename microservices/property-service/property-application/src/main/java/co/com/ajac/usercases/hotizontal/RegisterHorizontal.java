package co.com.ajac.usercases.hotizontal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.domain.HorizontalProperty;
import co.com.ajac.services.horizontal.HorizontalService;
import common.Query;
import domain.exceptions.NotSaveModelException;
import io.vavr.control.Either;
import io.vavr.control.Option;

@Component
public class RegisterHorizontal implements Query<String, HorizontalProperty>{


	private final HorizontalService service;

	@Autowired
	public RegisterHorizontal(HorizontalService service) {
		this.service = service;
	}

	@Override
	public String execute(HorizontalProperty arg0) {
		Either<String, Option<String>> eitherResult = service.registerHorizontalProperty(arg0);
		
		return  eitherResult.getOrElseThrow(
				() -> new NotSaveModelException(eitherResult.getLeft()))
				.getOrElseThrow(() -> new NotSaveModelException("Oups! No fue posible registrar esta propiedad"));
	}
}
