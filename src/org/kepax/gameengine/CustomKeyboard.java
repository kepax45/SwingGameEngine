package org.kepax.gameengine;

import java.awt.event.KeyEvent;
import java.lang.Math;

public class CustomKeyboard extends Keyboard {
	TexturedEntity Player;
	public CustomKeyboard(TexturedEntity e) {
		Player = e;
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
        }
    }
    public void updatePlayerMovement() {
        double xVelocity = Player.getVelocity().getXComponent();
        double yVelocity = Player.getVelocity().getYComponent();
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
        /*if(!(pressedKeys.contains(KeyEvent.VK_W) || pressedKeys.contains(KeyEvent.VK_S) || pressedKeys.contains(KeyEvent.VK_A) || pressedKeys.contains(KeyEvent.VK_D))) {
        	Player.setCollection("IDLE1");
        }*/
        /*if(pressedKeys.contains(KeyEvent.VK_A)) {
        	Player.setCollection("tepavac_standing");
        }*/
        if (pressedKeys.contains(KeyEvent.VK_W)) {
            yVelocity -= 1;
        }
        if (pressedKeys.contains(KeyEvent.VK_A)) {
            xVelocity -= 1;
        }
        if (pressedKeys.contains(KeyEvent.VK_S)) {
            yVelocity += 1; 
        }
        if (pressedKeys.contains(KeyEvent.VK_D)) {
            xVelocity += 1; // Move right
        }
        //xVelocity = Math.signum(xVelocity)*Math.max(Math.abs(xVelocity), 3);
        //yVelocity = Math.signum(yVelocity)*Math.max(Math.abs(yVelocity), 3);
        Player.setVelocity(xVelocity, yVelocity);
    }
}
