/**
 * @author Jasque Saydyk
 * CS 249: Lab 0 - Java Review
 * Description - InedibleException identifier
 */
public class InedibleException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public InedibleException() {
		super();
	}

	public InedibleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InedibleException(String message, Throwable cause) {
		super(message, cause);
	}

	public InedibleException(String message) {
		super(message);
	}

	public InedibleException(Throwable cause) {
		super(cause);
	}    
}
