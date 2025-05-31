package org.kepax.gameengine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

public abstract  class Mouse implements MouseListener, MouseMotionListener {
	protected final Set<Integer> pressedKeys = new HashSet<>();
    protected Game game;
    public Mouse(Game g) {
    	game = g;
    }
  
	@Override
	public void mouseClicked(MouseEvent e) {
		pressedKeys.add(e.getButton());
		mouseButtonClicked(e);
	}
	protected abstract void mouseButtonClicked(MouseEvent e);
	
	@Override
	public void mousePressed(MouseEvent e) {
		pressedKeys.add(e.getButton());
		mouseButtonPressed(e);
	}

	protected abstract void mouseButtonPressed(MouseEvent e);
	
	@Override
	public void mouseReleased(MouseEvent e) {
		pressedKeys.remove(e.getButton());
		mouseButtonReleased(e);
	}
	
	public abstract void mouseButtonReleased(MouseEvent e);

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	
	}
}
