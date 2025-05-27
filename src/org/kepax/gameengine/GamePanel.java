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
		if(game.currentTileMap != null)
			game.currentTileMap.drawTileMap(g, camera);
		if(game.drawHitboxes)
			Entity.drawHitboxes(g, camera);
		Entity.drawEntities(g, camera);
		
	}
}