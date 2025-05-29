package org.kepax.gameengine;

public class CustomGame extends Game{
	Entity player;
	public CustomGame(String title, int width, int height, int framerate, Entity player) {
		super(title, width, height, framerate);
		this.player = player;
	}
	@Override
	public void update() {
		((CustomKeyboard) k).updatePlayerMovement();
		player.setVelocityYComponent(player.getVelocity().getYComponent() + 0.5);
		if(CollisionChecker.collidingWithSolid(player, sceneManager.getScene().tileMap)) {
			CollisionChecker.resolveTileCollision(player, sceneManager.getScene().tileMap);
			if(player.getVelocity().getYComponent() > 0) {
				player.getVelocity().setYComponent(0);
			}
		}
		player.setVelocityXComponent(player.getVelocity().getXComponent()*0.9);
		
		c.follow(player);
	}
}
