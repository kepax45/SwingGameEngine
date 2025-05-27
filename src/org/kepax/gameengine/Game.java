package org.kepax.gameengine;

public class Game {
	Window w;
	long FrameRate;
	long lastFrameTime;
	long timeBetweenFrames;
	long frames;
	int width;
	int height;
	TileMap currentTileMap;
	Camera c;
	String title;
	Keyboard k;
	boolean drawHitboxes;
	public Game(String title, int width, int height, int framerate) {
		drawHitboxes = false;
		this.width = width;
		this.height = height;
		this.title = title;
		this.currentTileMap = null;
		FrameRate = framerate;
		lastFrameTime = System.currentTimeMillis();
		timeBetweenFrames = 1000 / FrameRate;
		frames = 0;
		c = new Camera(width, height);
		w = new Window(width, height, title, c, this);
		w.setVisible(false);
	}
	public Game(String title, int width, int height, int framerate, Keyboard k) {
		new Game(title, width, height, framerate);
		setKeyboard(k);
	}
	public void setTileMap(TileMap t) {
		currentTileMap = t;
	}
	public void start() {
		w.setVisible(true);
		initialization();
		while(w.isEnabled()) {
			long currentFrameTime = System.currentTimeMillis();
			long elapsedTime = currentFrameTime - lastFrameTime;
			if(elapsedTime >= timeBetweenFrames) {
				lastFrameTime = System.currentTimeMillis();
				frames++;
				Entity.updateEntityPositions();
				TexturedEntity.updateAnimations();
				update();
				w.repaint();
				
			} else {
				try {
					Thread.sleep(timeBetweenFrames - elapsedTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void setKeyboard(Keyboard k) {
		this.k = k;
		w.setKeyboard(k);
	}
	public void update() {
	}
	public void initialization() {
		
	}
}
