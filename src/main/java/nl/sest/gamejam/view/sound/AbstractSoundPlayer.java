package nl.sest.gamejam.view.sound;

import nl.sest.gamejam.exception.SoundLoadingException;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * @author Tim
 * @since 1/27/13 10:16 AM
 */
public abstract class AbstractSoundPlayer {

	private Sound sound;

	/**
	 * Constructor
	 */
	public AbstractSoundPlayer(String soundFile) {
		try {
			sound = new Sound(soundFile);
		} catch (SlickException e) {
			throw new SoundLoadingException("Could not load sound", e);
		}
	}

	/**
	 * Play sound
	 */
	public void play() {
		sound.play();
	}

	public void loop() {
		sound.loop(1f, 0.7f);
	}


}
