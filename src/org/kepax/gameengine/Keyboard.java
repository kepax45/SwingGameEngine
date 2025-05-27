package org.kepax.gameengine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public abstract class Keyboard implements KeyListener {
    protected final Set<Integer> pressedKeys = new HashSet<>();

    @Override
    public final void keyTyped(KeyEvent e) {
    	keysTyped(e);
    }

    protected abstract void keysTyped(KeyEvent e);

	@Override
    public final void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        keysPressed(e);
    }

    protected abstract void keysPressed(KeyEvent e);

	@Override
    public final void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
        keysReleased(e);
    }

	protected abstract void keysReleased(KeyEvent e);

    
}

