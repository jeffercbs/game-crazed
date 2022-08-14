package ui;

import controllers.KeyListener;
import ui.Scene;
import ui.Window;

import java.awt.event.KeyEvent;

public class SceneLevelEditor extends Scene {
    private boolean sceneChange = false;
    private float timeToChangeScene = 2.0f;

    public SceneLevelEditor() {
        System.out.println("Inside Scene Level Editor");
    }

    @Override
    public void update(float dt) {
        if (!sceneChange && KeyListener.isKeyPressed(KeyEvent.VK_SPACE)) {
            sceneChange = true;
        }

        if (sceneChange && timeToChangeScene > 0) {
            timeToChangeScene -= dt;
            Window.get().r -= dt * 5.0f;
            Window.get().g -= dt * 5.0f;
            Window.get().b -= dt * 5.0f;
            Window.get().a -= dt * 5.0f;
        } else if (sceneChange) {
            Window.changingScene(1);
        }
    }
}
