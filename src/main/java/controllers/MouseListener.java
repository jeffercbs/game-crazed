package controllers;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class MouseListener {
    private static MouseListener instance;
    private double xPost, yPost, lastX, lastY;
    private double scrollX, scrollY;
    private boolean MouseButtonPressed[] = new boolean[9];
    private boolean isDragging;

    private MouseListener() {
        this.scrollX = 0.0;
        this.scrollY = 0.0;
        this.xPost = 0.0;
        this.yPost = 0.0;
        this.lastX = 0.0;
        this.lastY = 0.0;
    }

    public static MouseListener get() {
        if (MouseListener.instance == null) {
            MouseListener.instance = new MouseListener();
        }

        return MouseListener.instance;
    }

    public static void MousePositionCallback(long window, double xPos, double yPost) {
        get().lastX = get().xPost;
        get().lastY = get().yPost;
        get().xPost = xPos;
        get().yPost = yPost;
        get().isDragging = get().MouseButtonPressed[0] || get().MouseButtonPressed[1] || get().MouseButtonPressed[2];
    }

    public static void MouseButtonCallback(long window, int button, int action, int mods) {
        if (action == GLFW_PRESS) {
            if (button < get().MouseButtonPressed.length) {
                get().MouseButtonPressed[button] = true;
            }
        } else if (action == GLFW_RELEASE) {
            if (button < get().MouseButtonPressed.length) {
                get().MouseButtonPressed[button] = false;
                get().isDragging = false;
            }
        }
    }

    public static void ScrollCallback(double window, double xOffSet, double yOffSet) {
        get().scrollX = xOffSet;
        get().scrollY = yOffSet;
    }

    public static void EndFrame() {
        get().scrollX = 0;
        get().scrollY = 0;
        get().lastX = get().xPost;
        get().lastY = get().yPost;
    }

    public static float getX() {
        return (float) get().xPost;
    }

    public static float getY() {
        return (float) get().yPost;
    }

    public static float getDx() {
        return (float) (get().lastX - get().xPost);
    }

    public static float getDy() {
        return (float) (get().lastY - get().yPost);
    }

    public static float getScrollX() {
        return (float) get().scrollX;
    }

    public static float getScrollY() {
        return (float) get().scrollY;
    }

    public static boolean isDragging() {
        return get().isDragging;
    }

    public static boolean MouseButtonDown(int button) {
        if (button < get().MouseButtonPressed.length) {
            return get().MouseButtonPressed[button];
        } else {
            return false;
        }
    }
}
