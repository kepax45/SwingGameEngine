package org.kepax.gameengine;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class GamePanel extends JPanel {
	Camera camera;
	Game game;
	public GamePanel(Camera camera, Game game) {
		this.camera = camera;
		this.game = game;
		setBackground(Color.BLACK);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(game.sceneManager.getScene().tileMap != null)
			game.sceneManager.getScene().tileMap.drawTileMap(g, camera);
		if(game.drawHitboxes)
			game.sceneManager.getScene().drawHitboxes(g, camera);
		game.sceneManager.getScene().drawEntities(g, camera);
		
	}
}