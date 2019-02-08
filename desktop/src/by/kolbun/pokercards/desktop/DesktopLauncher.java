package by.kolbun.pokercards.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import by.kolbun.pokercards.PokerCards;

import java.awt.*;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.resizable = true;
        config.fullscreen = false;

        config.width = 1280;
        config.height = 800;

        config.x = (Toolkit.getDefaultToolkit().getScreenSize().width - config.width) / 2;
        config.y = (Toolkit.getDefaultToolkit().getScreenSize().height - config.height) / 2;

        config.title = "PokerUtilities";

        new LwjglApplication(new PokerCards(""), config);
//        new LwjglApplication(new PokerCards("android/assets/"), config);
    }
}
