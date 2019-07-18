package coremodel.excepciones;

public class TechnicalException extends Exception {

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
