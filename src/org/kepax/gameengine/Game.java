package org.kepax.gameengine;

public class Game {
	public Window w;
	long FrameRate;
	long lastFrameTime;
	long timeBetweenFrames;
	long frames;
	public int width;
	public int height;
	protected Camera c;
	String title;
	Keyboard k;
	boolean drawHitboxes;
	protected SceneManager sceneManager;
	protected Mouse m;
	public SceneManager getSceneManager() {
		return sceneManager;
	}
	protected Window getWindow() {
		return w;
	}
	public Game(String title, int width, int height, int framerate) {
		drawHitboxes = false;
		this.width = width;
		this.height = height;
		this.title = title;
		FrameRate = framerate;
		lastFrameTime = System.currentTimeMillis();
		timeBetweenFrames = 1000 / FrameRate;
		frames = 0;
		c = new Camera(width, height);
		w = new Window(width, height, title, c, this);
		w.setVisible(false);
		sceneManager = new SceneManager(null, this);
	}
	public Game(String title, int width, int height, int framerate, Keyboard k) {
		new Game(title, width, height, framerate);
		setKeyboard(k);
	}
	public void start() {
		
		initialization();
		w.setVisible(true);
		while(w.isEnabled()) {
			long currentFrameTime = System.currentTimeMillis();
			long elapsedTime = currentFrameTime - lastFrameTime;
			if(elapsedTime >= timeBetweenFrames) {
				lastFrameTime = System.currentTimeMillis();
				frames++;
				sceneManager.getScene().updateEntityPositions();
				sceneManager.getScene().updateAnimations();
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
	public void setMouse(Mouse m) {
		this.m = m;
		w.setMouse(m);
	}
	public void update() {
	}
	public void initialization() {
		
	}
}
