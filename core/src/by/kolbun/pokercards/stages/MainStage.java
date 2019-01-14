package by.kolbun.pokercards.stages;

import by.kolbun.pokercards.ui.Gui;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MainStage extends Stage {

    private final Gui gui;

    public MainStage(StretchViewport viewport, SpriteBatch batch) {
        super(viewport, batch);
        getBatch().setProjectionMatrix(getCamera().combined);
        gui = new Gui();
        addActor(gui);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw() {
        super.draw();
    }

    // up - 19
    // down - 20
    // left - 21
    // right - 22
    // 1 - 8, 2 - 9, 3 - 10, 4 - 11, 5 - 12
    // q 45, w 51, e 33, a 29, s 47, d 32

    // TODO: 12.01.2019 Выключить отмену выделения кнопки при повторном клике

    @Override
    public boolean keyDown(int keyCode) {
        gui.keyPressed(keyCode);

        return super.keyDown(keyCode);
    }
}
