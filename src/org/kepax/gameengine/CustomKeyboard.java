package org.kepax.gameengine;

import java.awt.event.KeyEvent;
import java.lang.Math;

public class CustomKeyboard extends Keyboard {
	TexturedEntity Player;
	Boolean jumping;
	public CustomKeyboard(Game g, TexturedEntity e) {
		super(g);
		Player = e;
		jumping = false;
		
	}
    @Override
    protected void keysTyped(KeyEvent e) {
        //System.out.println("Key Typed: " + e.getKeyChar());
    }

    @Override
    protected void keysPressed(KeyEvent e) {
        //System.out.println("Key Pressed: " + e.getKeyCode());
       // updatePlayerMovement();
    	
    }

    @Override
    protected void keysReleased(KeyEvent e) {
    	boolean moving = (pressedKeys.contains(KeyEvent.VK_A) || pressedKeys.contains(KeyEvent.VK_D) || pressedKeys.contains(KeyEvent.VK_W) || pressedKeys.contains(KeyEvent.VK_S)) ;
        //System.out.println("Key Released: " + e.getKeyCode());
        if(e.getKeyCode() == KeyEvent.VK_A && !moving) {
        	Player.setCollection("idle_left");
        }
        if(e.getKeyCode() == KeyEvent.VK_S && !moving) {
        	Player.setCollection("idle_down");
        }
        if(e.getKeyCode() == KeyEvent.VK_D && !moving) {
        	Player.setCollection("idle_right");
        }
        if(e.getKeyCode() == KeyEvent.VK_W && !moving) {
        	Player.setCollection("idle_up");
        	//Player.setVelocityYComponent(Player.getVelocity().getYComponent() - 10);
        }
    }
    public void updatePlayerMovement() {
        double xVelocity = Player.getVelocity().getXComponent();
        double yVelocity = Player.getVelocity().getYComponent();
        if(jumping && CollisionChecker.isAboveSolidTile(Player, game.sceneManager.getScene().tileMap)) jumping = false;
        //System.out.println(pressedKeys);
        if(pressedKeys.contains(KeyEvent.VK_W)) {
        	Player.setCollection("walking_up");
        }
        if(pressedKeys.contains(KeyEvent.VK_S)) {
        	Player.setCollection("walking_down");
        }
        if(pressedKeys.contains(KeyEvent.VK_D)) {
        	Player.setCollection("walking_right");
        }
        if(pressedKeys.contains(KeyEvent.VK_A)) {
        	Player.setCollection("walking_left");
        }
        if (pressedKeys.contains(KeyEvent.VK_A)) {
            xVelocity -= 1;
        }
        if (pressedKeys.contains(KeyEvent.VK_D)) {
            xVelocity += 1;
        }
        if(pressedKeys.contains(KeyEvent.VK_W) && !jumping && !CollisionChecker.isBelowSolidTile(Player, game.sceneManager.getScene().tileMap)&& CollisionChecker.isAboveSolidTile(Player, game.sceneManager.getScene().tileMap)) {
        	yVelocity -= 30;
        	jumping = true;
        }
        Player.setVelocity(xVelocity, yVelocity);
    }
}
