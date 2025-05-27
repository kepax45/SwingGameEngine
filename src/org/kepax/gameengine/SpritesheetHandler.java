package org.kepax.gameengine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class SpritesheetHandler {
	public static List<BufferedImage> parseSpritesheet(String s, int start_index, int end_index, int offsetX, int offsetY) {
		List<BufferedImage> result = new ArrayList<BufferedImage>();
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int startX = start_index % image.getWidth();
		int startY = start_index / image.getHeight();
		int cols = image.getWidth() / offsetX;
		int rows = image.getHeight() / offsetY;
		int total = end_index - start_index + 1;
		int cnt = 0;
		for(int i = 0; i < rows && cnt < total; i++) {
			for(int j = 0; j < cols && cnt < total; j++) {
				result.add(image.getSubimage(startX + offsetX*j, startY + offsetY*i, offsetX, offsetY));
				cnt++;
			}
		}
		return result;
	}
}
