package ui;

import ui.Scene;

public class SceneLevel extends Scene {
    public SceneLevel() {
        System.out.println("Inside Scene Level");
        Window.get().r = 1;
        Window.get().g = 1;
        Window.get().b = 1;
    }

    @Override
    public void update(float dt) {

    }
}
