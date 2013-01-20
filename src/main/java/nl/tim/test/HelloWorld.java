package nl.tim.test;

import org.newdawn.slick.*;
import org.newdawn.slick.loading.DeferredResource;
import org.newdawn.slick.loading.LoadingList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HelloWorld extends BasicGame {


    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);
    /**
     * The next resource to load
     */
    private DeferredResource nextResource;

    private Image image;

    private boolean started;

    public HelloWorld() {
        super("Hello World");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        LoadingList.setDeferredLoading(true);

        new Image("images/cursor_arrow.png");
        image = new Image("images/earth_128.png");
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        if (nextResource != null) {
            try {
                nextResource.load();
                // slow down loading for example purposes
                Thread.sleep(1000);

            } catch (IOException e) {
                throw new SlickException("Failed to load: " + nextResource.getDescription(), e);
            } catch (InterruptedException ie) {
                throw new RuntimeException("Interrupted", ie);
            }

            nextResource = null;
        }

        if (LoadingList.get().getRemainingResources() > 0) {
            nextResource = LoadingList.get().getNext();
        } else {
            if (!started) {
                started = true;
            }
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        if (nextResource != null) {
            g.drawString("Loading: " + nextResource.getDescription(), 100, 100);

            float total = LoadingList.get().getTotalResources();
            float loaded = LoadingList.get().getTotalResources() - LoadingList.get().getRemainingResources();

            float bar = (loaded / total) * 500;

            g.fillRect(100, 150, bar, 20);
            g.drawRect(100, 150, 500, 20);

            LOGGER.debug("Total {}", total);
            LOGGER.debug("loaded {}", loaded);
            LOGGER.debug("Bar: {}", bar);
        } else if (started) {
            image.draw(100, 200);
            g.drawString("LOADING COMPLETE", 100, 500);
        }
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new HelloWorld());

        app.setDisplayMode(800, 600, false);
        app.start();
    }
}