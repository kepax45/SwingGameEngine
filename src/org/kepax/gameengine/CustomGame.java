package org.kepax.gameengine;

public class CustomGame extends Game{
	Entity player;
	public CustomGame(String title, int width, int height, int framerate, Entity player) {
		super(title, width, height, framerate);
		this.player = player;
	}
	@Override
	public void update() {
		if(!CollisionChecker.isAboveSolidTile(player, sceneManager.getScene().tileMap)) player.setVelocityYComponent(player.getVelocity().getYComponent() + 1.3);
		((CustomKeyboard) k).updatePlayerMovement();
		if (CollisionChecker.collidingWithSolidTile(player, sceneManager.getScene().tileMap)) {
			CollisionChecker.resolveTileCollision(player, sceneManager.getScene().tileMap);
		}
		
		player.setVelocityXComponent(player.getVelocity().getXComponent() * 0.9);
		player.setVelocityYComponent(player.getVelocity().getYComponent() * 0.9);
		c.follow(player);
	}
}
