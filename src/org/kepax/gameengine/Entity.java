package org.kepax.gameengine;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


abstract public class Entity {
	public static List<Entity> list = new ArrayList<Entity>();
	private int ID;
	private double x, y, width, height;
	Rectangle boundingBox;
	private Vector2D velocity;
	protected Entity() {
		//if(list == null) list = new ArrayList<Entity>();
		velocity = new Vector2D(0, 0);
		list.add(this);
		boundingBox = new Rectangle(0, 0, 0, 0);
	}
	public static void drawHitboxes(Graphics g, Camera c) {
		Rectangle tmp;
		for(Entity e : list) {
			tmp = e.getBoundingBox();
			g.drawRect(tmp.x - c.x, tmp.y - c.y, tmp.width, tmp.height);
		}
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public Vector2D getVelocity() {
		return velocity;
	}
	public abstract void draw(Graphics g, Camera c);
	
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setBoundingBox(int x, int y, int width, int height) {
		boundingBox.x = x;
		boundingBox.y = y;
		boundingBox.width = width;
		boundingBox.height = height;
	}
	public Rectangle getBoundingBox() {
		return new Rectangle((int) (x + boundingBox.x), (int) (y + boundingBox.y), boundingBox.width, boundingBox.height);
	}
	void move() {
		this.setX(this.getX() + this.velocity.getXComponent());
		this.setY(this.getY() + this.velocity.getYComponent());
	}
	public void setVelocity(double x_comp, double y_comp) {
		velocity.setXComponent(x_comp);
		velocity.setYComponent(y_comp);
	}
	public void setVelocityXComponent(double x_comp) {
		velocity.setXComponent(x_comp);
	}
	public void setVelocityYComponent(double y_comp) {
		velocity.setYComponent(y_comp);
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Rectangle getRectangle() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}
}
