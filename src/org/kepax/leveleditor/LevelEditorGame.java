package org.kepax.leveleditor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.kepax.gameengine.Entity;
import org.kepax.gameengine.Game;


public class LevelEditorGame extends Game {
	JTextArea xPosArea = new JTextArea(), yPosArea = new JTextArea();
	Entity camEntity;
	public LevelEditorGame(String title, int width, int height, int framerate) {
		super(title, width, height, framerate);
		camEntity = new Entity();
		camEntity.setX(150);
		camEntity.setY(150);
		camEntity.setBoundingBox(0, 0, 0, 0);
		
	}
	@Override
	public void initialization() {
	    JMenuBar menuBar = new JMenuBar();
	    JMenu fileMenu = new JMenu("File");
	    menuBar.add(fileMenu);
	    w.setJMenuBar(menuBar);

	    w.panel.setLayout(new BorderLayout());

	    JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));

	    xPosArea = new JTextArea(1, 10);
	    yPosArea = new JTextArea(1, 10);
	    xPosArea.setEditable(false);
	    yPosArea.setEditable(false);
	    xPosArea.setFocusable(false);
	    yPosArea.setFocusable(false);
	    xPosArea.setText("" + camEntity.getX());
	    yPosArea.setText("" + camEntity.getY());

	    topRightPanel.add(new JLabel("X:"));
	    topRightPanel.add(xPosArea);
	    topRightPanel.add(new JLabel("Y:"));
	    topRightPanel.add(yPosArea);

	    w.panel.add(topRightPanel, BorderLayout.NORTH);
	    w.setResizable(false);
	}
	@Override
	public void update() {
		xPosArea.setText(""+camEntity.getX());
		yPosArea.setText(""+camEntity.getY());
		c.follow(camEntity);
		
	}
}
