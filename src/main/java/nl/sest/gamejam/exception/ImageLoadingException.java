package nl.sest.gamejam.exception;

/**
 * @author Tim
 * @since 1/26/13 10:31 PM
 */
public class ImageLoadingException extends RuntimeException {

	public ImageLoadingException(String message) {
		super(message);
	}

	public ImageLoadingException(String message, Throwable cause) {
		super(message, cause);
	}
}
