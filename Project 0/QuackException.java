/**
 * @author Jasque Saydyk
 * CS 249: Lab 0 - Java Review
 * Description - QuackException identifier
 */
public class QuackException extends Exception {

	private static final long serialVersionUID = 1L;

	public QuackException() {
		super();
	}

	public QuackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public QuackException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuackException(String message) {
		super(message);
	}

	public QuackException(Throwable cause) {
		super(cause);
	}
}
