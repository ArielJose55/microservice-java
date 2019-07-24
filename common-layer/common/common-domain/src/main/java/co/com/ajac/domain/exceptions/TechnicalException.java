package co.com.ajac.domain.exceptions;

public class TechnicalException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TechnicalException(String mensaje) {
        super(mensaje);
    }
    public TechnicalException(String mensaje, Throwable e) {
        super(mensaje, e);
    }

}
