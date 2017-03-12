/**
 * @author Jasque Saydyk
 * CS 249: Lab 0 - Java Review
 * Description - EmptyBagException identifier
 */
public class EmptyBagException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyBagException() {
		super();
	}

	public EmptyBagException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmptyBagException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyBagException(String message) {
		super(message);
	}

	public EmptyBagException(Throwable cause) {
		super(cause);
	}
}
