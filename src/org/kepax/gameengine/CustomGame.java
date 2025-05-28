package org.kepax.gameengine;

public class CustomGame extends Game{
	Entity player;
	Entity te;
	public CustomGame(String title, int width, int height, int framerate, Entity e, Entity te) {
		super(title, width, height, framerate);
		player = e;
		this.te = te;
	}
	@Override
	public void update() {
		((CustomKeyboard) k).updatePlayerMovement();
		player.setVelocity(player.getVelocity().getXComponent()*0.9, player.getVelocity().getYComponent()*0.9);
		if(CollisionChecker.CollidingAABB(player.getBoundingBox(), te.getBoundingBox())) {
			CollisionChecker.resolveCollisionMTV(player, te);
			player.setVelocity(player.getVelocity().getXComponent()*0.9, player.getVelocity().getYComponent()*0.9);
		}
		CollisionChecker.resolveTileCollision(player, currentTileMap);
		CollisionChecker.resolveTileCollision(te, currentTileMap);
		c.follow(player);
	}
}
