package co.com.ajac.exceptions;

public class NotSaveModelException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public NotSaveModelException(String message) {
		super(message);
	}
}
