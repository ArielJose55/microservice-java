package co.com.ajac.http.enpoints;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import coremodel.excepciones.BusinessException;
import coremodel.excepciones.ErrorResponse;
import domain.exceptions.ModelNotFoundException;
import domain.exceptions.ViolatedValidationException;


@ControllerAdvice
public class ManejadorDeError extends ResponseEntityExceptionHandler{

	@ExceptionHandler(BusinessException.class)
	public <T extends BusinessException> ResponseEntity<ErrorResponse> handleException(T ex,  WebRequest request){
		ErrorResponse detalls = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
		return new ResponseEntity<>(detalls, HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler(ModelNotFoundException.class)
	public <T extends ModelNotFoundException> ResponseEntity<ErrorResponse> handleException(T ex,  WebRequest request){
		ErrorResponse detalls = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
		return new ResponseEntity<>(detalls, HttpStatus.NOT_FOUND);			
	}
	
	@ExceptionHandler(ViolatedValidationException.class)
	public <T extends ViolatedValidationException> ResponseEntity<ErrorResponse> handleException(T ex,  WebRequest request){
		ErrorResponse detalls = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
		return new ResponseEntity<>(detalls, HttpStatus.NOT_FOUND);	
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder sb = new StringBuilder();
		ex.getBindingResult().getAllErrors().stream().map(err -> ((FieldError) err)).forEach(error -> {
			sb.append("{ ");
			sb.append(error.getField());
			sb.append(" : ");
			sb.append(error.getDefaultMessage());
			sb.append("}, ");
		});

		return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), sb.toString(), true, "Corriga los campos no validos e intente de nuevo"), status);
	}
	
}
