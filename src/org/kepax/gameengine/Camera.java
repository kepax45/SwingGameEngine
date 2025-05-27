package org.kepax.gameengine;

public class Camera {
    public int x, y;
    public int width, height;
    

    public Camera(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void follow(Entity target) {
        this.x = (int) (target.getX() - width / 2.0);
        this.y = (int) (target.getY() - height / 2.0);
    }
}