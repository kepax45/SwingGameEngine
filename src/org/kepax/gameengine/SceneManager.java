package org.kepax.gameengine;

public class SceneManager {
	Scene scene = null;
	Game game;
	public SceneManager(Scene sc, Game g) {
		game = g;
		if(sc == null) {
			setScene(new Scene() {
				@Override
				public void initialize() {
					
				}
			});
		} else 
			setScene(sc);
	}
	public void setScene(Scene scene) {
		this.scene = scene;
		scene.initialize();
	}
	public Scene getScene() {
		return scene;
	}
	
}
