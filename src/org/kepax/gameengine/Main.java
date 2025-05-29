package org.kepax.gameengine;
import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		AnimationMap.putAnimationCollection("walking_right", new AnimationCollection("res/1 Characters/1/S_Walk2.png", 32, 32));
		AnimationMap.putAnimationCollection("walking_down", new AnimationCollection("res/1 Characters/1/D_Walk.png", 32, 32));
		AnimationMap.putAnimationCollection("walking_left", new AnimationCollection("res/1 Characters/1/S_Walk.png", 32, 32));
		AnimationMap.putAnimationCollection("walking_up", new AnimationCollection("res/1 Characters/1/U_Walk.png", 32, 32));
		AnimationMap.putAnimationCollection("idle_up", new AnimationCollection("res/1 Characters/1/U_Idle.png", 32, 32));
		AnimationMap.putAnimationCollection("idle_left", new AnimationCollection("res/1 Characters/1/S_Idle.png", 32, 32));
		AnimationMap.putAnimationCollection("idle_down", new AnimationCollection("res/1 Characters/1/D_Idle.png", 32, 32));
		AnimationMap.putAnimationCollection("idle_right", new AnimationCollection("res/1 Characters/1/S_Idle2.png", 32, 32));
		AnimationMap.getAnimationCollection("walking_down").scale(3);
		AnimationMap.getAnimationCollection("walking_left").scale(3);
		AnimationMap.getAnimationCollection("walking_up").scale(3);
		AnimationMap.getAnimationCollection("walking_right").scale(3);
		AnimationMap.getAnimationCollection("idle_up").scale(3);
		AnimationMap.getAnimationCollection("idle_left").scale(3);
		AnimationMap.getAnimationCollection("idle_right").scale(3);
		AnimationMap.getAnimationCollection("idle_down").scale(3);
		TexturedEntity player = new TexturedEntity(0.1);
		player.setX(100);
		player.setY(0);
		player.setCollection("idle_right");
		Scene sc = new Scene() {
			@Override
			public void initialize() {
				Tile[] tileSet = Tile.createTileSet("res/tiles.png", 0, 3, 50, 50);
				tileSet[0].setSolid(true);
				this.tileMap = TileMap.loadTileMap("res/mapa.txt", tileSet, 50, 0, 0);
				player.setBoundingBox(30, 10, 40, 50);
				addEntity(player);
			}
		};
		CustomGame cg = new CustomGame("naziv22", 800, 600, 60, player);
		cg.drawHitboxes = true;
		cg.sceneManager.setScene(sc);
		cg.setKeyboard(new CustomKeyboard(player));
		cg.start();
	}
}
