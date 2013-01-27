package nl.sest.gamejam.exception;

/**
 * @author Tim
 * @since 1/27/13 10:22 AM
 */
public class SoundLoadingException extends RuntimeException {

	public SoundLoadingException(String message) {
		super(message);
	}

	public SoundLoadingException(String message, Throwable cause) {
		super(message, cause);
	}
}
