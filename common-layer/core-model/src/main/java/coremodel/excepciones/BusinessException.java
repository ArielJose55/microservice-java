package coremodel.excepciones;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 4285009987103759501L;

	public BusinessException(String message) {
		super(message);
	}
}
