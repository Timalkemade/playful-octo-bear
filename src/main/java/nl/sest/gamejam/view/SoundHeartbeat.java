package nl.sest.gamejam.view;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * User: JMIEGHEM
 * Date: 26-1-13
 * Time: 0:06
 */
public class SoundHeartbeat implements Renderer {

    private String SoundFile = "sounds/heartbeat.ogg";

    /**
     * Constructor
     */
    public SoundHeartbeat() {
    }

    /**
     * Play sound
     */
    public void render() {
        try{
            Sound Heartbeat = new Sound(SoundFile);
            Heartbeat.play();
        }
        catch (SlickException ex)
        {
        }
    }



}
