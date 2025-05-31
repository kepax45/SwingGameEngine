package org.kepax.leveleditor;

import java.awt.event.MouseEvent;

import org.kepax.gameengine.Game;
import org.kepax.gameengine.Mouse;

public class EditorMouse extends Mouse {
	boolean firstLog = false;
	public int startX, startY;
	LevelEditorGame lg;
	public int distX;
	public int distY;
	public EditorMouse(LevelEditorGame lg) {
		super((Game) lg);
		this.lg = lg;
		startX = 0;
		startY = 0;
	}

	@Override
	protected void mouseButtonClicked(MouseEvent e) {
		
	}

	@Override
	protected void mouseButtonPressed(MouseEvent e) {
		//System.out.println("pressed");
		startX = e.getX();
		startY = e.getY();
	}

	@Override
	public void mouseButtonReleased(MouseEvent e) {
		firstLog = false;
		startX = -1;
		startY = -1;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		distX = e.getX() - startX;
		distY = e.getY() - startY;
		startY = e.getY();
		startX = e.getX();
		lg.camEntity.setX(lg.camEntity.getX() - distX);
		lg.camEntity.setY(lg.camEntity.getY() - distY);
		
	}

}
