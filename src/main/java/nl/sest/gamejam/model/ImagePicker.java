package nl.sest.gamejam.model;

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

    public ImagePicker ()
    {
    }

    public Image pick(String map){
        File[] fileList = getImages(map);
        int max = fileList.length;
        int random = (int)(Math.random() * max);
        String file = fileList[random].getPath();

        Image pickImg = null;
        try {
            pickImg = new Image(file);
        } catch (SlickException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return pickImg;
    }


    private File[] getImages(String map){
        ClasspathLocation resourcemap = new ClasspathLocation();
        URL mappath = resourcemap.getResource("images/"+map+"/");

        URI mapUri = null;
        try {
            mapUri = mappath.toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        File directory = new File(mapUri);
        File[] fileList = directory.listFiles();
        return fileList;
    }

}
