package org.kepax.gameengine;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Window extends JFrame {
	private int width, height;
	private String title;
	public GamePanel panel;
	public Window(int width, int height, String title, Camera c, Game g) {
		this.width = width;
		this.height = height;
		this.title = title;
		setTitle(title);
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new GamePanel(c, g);
		this.add(panel);
	}
	void drawAllEntities() {
		panel.paintComponent(getGraphics());
		panel.repaint();
		repaint();
	}
	public void setKeyboard(Keyboard k) {
		this.addKeyListener(k);
	}
	public void setMouse(Mouse m) {
		this.addMouseListener(m);
		this.addMouseMotionListener(m);
	}
	
}
