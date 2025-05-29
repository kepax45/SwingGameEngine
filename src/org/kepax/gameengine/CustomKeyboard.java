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
    	
    }
}
