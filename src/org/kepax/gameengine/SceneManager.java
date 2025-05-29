package org.kepax.gameengine;

public class SceneManager {
	Scene scene = null;
	public SceneManager() {
		
	}
	public void setScene(Scene scene) {
		this.scene = scene;
		scene.initialize();
	}
	public Scene getScene() {
		return scene;
	}
	
}
