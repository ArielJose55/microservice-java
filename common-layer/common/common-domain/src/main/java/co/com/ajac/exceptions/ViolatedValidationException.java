package co.com.ajac.exceptions;

public class ViolatedValidationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ViolatedValidationException(String message) {
		super(message);
	}
}
