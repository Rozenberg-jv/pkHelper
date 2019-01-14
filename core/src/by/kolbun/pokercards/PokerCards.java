package by.kolbun.pokercards;

import by.kolbun.pokercards.screens.MainScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class PokerCards extends Game {

    private final String assetsPath;

    public PokerCards(String assetsPath) {
        this.assetsPath = assetsPath;
    }

    @Override
    public void create() {
        Assets.load(assetsPath);
        Screen screen = new MainScreen();

        setScreen(screen);
    }

    @Override
    public void dispose() {
        Assets.dispose();
    }
}
