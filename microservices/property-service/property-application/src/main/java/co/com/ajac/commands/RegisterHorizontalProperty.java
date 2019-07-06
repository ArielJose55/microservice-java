package co.com.ajac.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ajac.domain.HorizontalProperty;
import co.com.ajac.services.horizontal.HorizontalService;
import common.Command;
import domain.exceptions.NotSaveModelException;
import io.vavr.control.Either;
import io.vavr.control.Option;

@Component
public class RegisterHorizontalProperty implements Command<HorizontalProperty>{


	private final HorizontalService service;

	@Autowired
	public RegisterHorizontalProperty(HorizontalService service) {
		this.service = service;
	}

	@Override
	public void execute(HorizontalProperty arg0) {
		Either<String, Option<String>> eitherResult = service.registerHorizontalProperty(arg0);
		
		eitherResult.getOrElseThrow(
				() -> new NotSaveModelException(eitherResult.getLeft()))
				.getOrElseThrow(() -> new NotSaveModelException("Oups! No fue posible registrar esta propiedad"));
	}
}
