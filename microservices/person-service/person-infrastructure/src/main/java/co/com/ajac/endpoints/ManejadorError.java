package co.com.ajac.endpoints;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.ajac.domain.exceptions.BusinessException;
import co.com.ajac.domain.exceptions.ErrorResponse;
import co.com.ajac.domain.exceptions.TechnicalException;


@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler{

	@ExceptionHandler(BusinessException.class)
	public <T extends BusinessException> ResponseEntity<ErrorResponse> handleException(T ex,  WebRequest request){
		ErrorResponse detalls = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
		return new ResponseEntity<>(detalls, HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler(TechnicalException.class)
	public <T extends TechnicalException> ResponseEntity<ErrorResponse> handleException(T ex,  WebRequest request){
		ErrorResponse detalls = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
		return new ResponseEntity<>(detalls, HttpStatus.INTERNAL_SERVER_ERROR);			
	}
}
