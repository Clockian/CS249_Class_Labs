/**
 * @author Jasque Saydyk
 * CS 249: Lab 0 - Java Review
 * Description - OutOfSpaceException identifier
 */
public class OutOfSpaceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OutOfSpaceException() {
		super();
	}

	public OutOfSpaceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OutOfSpaceException(String message, Throwable cause) {
		super(message, cause);
	}

	public OutOfSpaceException(String message) {
		super(message);
	}

	public OutOfSpaceException(Throwable cause) {
		super(cause);
	}
}
