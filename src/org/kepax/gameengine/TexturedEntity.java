package org.kepax.gameengine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TexturedEntity extends Entity {
	protected AnimationCollection collection;
	protected double switchTime;
	public TexturedEntity(double switchTime) {
		this.switchTime = switchTime;
	}
	@Override
	public void draw(Graphics g, Camera c) {
		g.drawImage(collection.getCurrentImage(), (int) (getX() - c.x), (int) (getY() - c.y), null);
	}
	
	public void setCollection(String collectionName) {
		collection = AnimationMap.getAnimationCollection(collectionName);
	}
	
}
