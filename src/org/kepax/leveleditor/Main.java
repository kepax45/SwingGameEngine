package org.kepax.leveleditor;
import org.kepax.gameengine.*;

public class Main {
	public static void main(String[] args) {
		LevelEditorGame game = new LevelEditorGame("Swing level editor" ,800, 600, 60);
		game.getSceneManager().setScene(new Scene() {
			@Override
			public void initialize() {
				
			}
		});
		game.setMouse(new EditorMouse(game));
		game.start();
		
	}
}
