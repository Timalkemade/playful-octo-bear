package nl.sest.gamejam.model;

import nl.sest.gamejam.exception.ImageLoadingException;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.ClasspathLocation;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * User: JMIEGHEM
 * Date: 26-1-13
 * Time: 15:49
 */
public class ImagePicker {

	public ImagePicker() {
	}

	public Image pick(String map) {
		File[] fileList = getImages(map);
		int max = fileList.length;
		int random = (int) (Math.random() * max);
		String file = fileList[random].getPath();

		Image pickImg;
		try {
			pickImg = new Image(file);
		} catch (SlickException e) {
			throw new ImageLoadingException("Failed to load image", e);
		}
		return pickImg;
	}


	private File[] getImages(String map) {
		ClasspathLocation resourcemap = new ClasspathLocation();
		URL mappath = resourcemap.getResource("images/" + map + "/");

		URI mapUri;
		try {
			mapUri = mappath.toURI();
		} catch (URISyntaxException e) {
			throw new RuntimeException("problem in uri", e);
		}

		File directory = new File(mapUri);
		File[] fileList = directory.listFiles();
		return fileList;
	}

}
