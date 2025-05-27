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
		TexturedEntity te = new TexturedEntity(0.1);
		TexturedEntity te2 = new TexturedEntity(0.1);
		te2.setCollection("idle_right");
		te2.setX(-100);
		te2.setY(-100);
		te.setBoundingBox(25, 10, 40, 50);
		te2.setBoundingBox(25, 10, 40, 50);
		te.setCollection("walking_down");
		CustomGame cg = new CustomGame("naziv22", 800, 600, 60, te, te2);
		Tile[] tileSet = Tile.createTileSet("res/tiles.png", 0, 2, 50, 50);
		tileSet[1].setSolid(true);
		tileSet[2].setSolid(true);
		cg.drawHitboxes = true;
		cg.setTileMap(TileMap.loadTileMap("res/mapa.txt", tileSet, 50, -500, -500));
		cg.setKeyboard(new CustomKeyboard(te));
		cg.start();
	}
}
