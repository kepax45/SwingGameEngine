package org.kepax.gameengine;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

class ImageScaler {

    public static BufferedImage scale(BufferedImage src, int width, int height) {
    	BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                             RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        
        g2d.drawImage(src, 0, 0, width, height, null);
        g2d.dispose();

        return scaledImage;
    }
}
class AnimationNode {
	BufferedImage nodeImg;
	AnimationNode next;
	AnimationNode prev;
	int scalingFactor;
	public AnimationNode(String path) {
		next = null;
		prev = null;
		try {
			nodeImg = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public AnimationNode(BufferedImage img) {
		next = null;
		prev = null;
		nodeImg = img;
	}
}

public class AnimationCollection {
	AnimationNode head;
	AnimationNode curr;
	long lastUpdateMillis;
	public AnimationCollection() {
		head = null;
		curr = null;
		lastUpdateMillis = System.currentTimeMillis();
	}
	public AnimationCollection(String path, int offsetX, int offsetY) {
		new AnimationCollection();
		List<BufferedImage> ls = SpritesheetHandler.parseSpritesheet(path, 0, 256, offsetX, offsetY);
		for(BufferedImage img : ls) {
			addAnimationFrame(new AnimationNode(img));
		}
	}
	public AnimationCollection(String path, int start_index, int end_index, int offsetX, int offsetY) {
		new AnimationCollection();
		List<BufferedImage> ls = SpritesheetHandler.parseSpritesheet(path, start_index, end_index, offsetX, offsetY);
		System.out.println(ls.size());
		for(BufferedImage img : ls) {
			addAnimationFrame(new AnimationNode(img));
		}
	}
	
	public void scale(int scalingFactor) {
		AnimationNode tmp = head;
		while(true) {
			tmp.nodeImg = ImageScaler.scale(tmp.nodeImg, scalingFactor*tmp.nodeImg.getWidth(), scalingFactor*tmp.nodeImg.getHeight());
			tmp = tmp.next;
			if(tmp == head) break;
		}
	}
	
	public void addAnimationFrame(AnimationNode newNode) {
		if(head == null) {
			head = newNode;
			head.prev = head;
			head.next = head;
			curr = head;
			return;
		}
		AnimationNode tail = head.prev;
		tail.next = newNode;
		newNode.prev = tail;
		newNode.next = head;
		head.prev = newNode;
		
	}
	public void update() {
		if(curr != null) {
			lastUpdateMillis = System.currentTimeMillis();
			curr = curr.next;
		}
	}
	public BufferedImage getCurrentImage() {
		if(curr == null) return null;
		return curr.nodeImg;
	}
	
	
}
