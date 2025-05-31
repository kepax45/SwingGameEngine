package org.kepax.leveleditor;
import org.kepax.gameengine.AnimationCollection;
import org.kepax.gameengine.AnimationMap;
import org.kepax.gameengine.Scene;
import org.kepax.gameengine.TexturedEntity;

public class Main {
	public static void main(String[] args) {
		LevelEditorGame game = new LevelEditorGame("Swing level editor" ,800, 600, 60);
		AnimationMap.putAnimationCollection("col1", new AnimationCollection("res/tepavac.png", 0, 0, 50, 50));
		game.getSceneManager().setScene(new Scene() {
			@Override
			public void initialize() {
				TexturedEntity te = new TexturedEntity(0.1);
				te.setCollection("col1");
				te.setX(0);
				te.setY(0);
				addEntity(te);
			}
		});
		game.setMouse(new EditorMouse(game));
		game.start();
		
	}
}
