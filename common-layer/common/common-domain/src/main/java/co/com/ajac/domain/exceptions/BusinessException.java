package co.com.ajac.domain.exceptions;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 4285009987103759501L;

	public BusinessException(String message) {
		super(message);
	}
}
