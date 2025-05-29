package org.kepax.gameengine;

public class CustomGame extends Game{
	Entity player;
	public CustomGame(String title, int width, int height, int framerate, Entity player) {
		super(title, width, height, framerate);
		this.player = player;
	}
	@Override
	public void update() {
		player.setVelocityYComponent(player.getVelocity().getYComponent() + 0.2);
		CollisionChecker.resolveTileCollision(player, this.sceneManager.getScene().tileMap);
		c.follow(player);
	}
}
