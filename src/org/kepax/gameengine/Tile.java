package org.kepax.gameengine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class Tile {
	public BufferedImage image;
	boolean solid;
	public Tile(BufferedImage image) {
		this.image = image;
	}
	public Tile(String path) {
		try {
			this.image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	boolean isSolid() {
		return solid;
	}
	void setSolid(boolean value) {
		solid = value;
	}
	public static Tile[] createTileSet(String filePath, int start_index, int end_index, int offsetX, int offsetY) {
		List<BufferedImage> l = SpritesheetHandler.parseSpritesheet(filePath, start_index, end_index, offsetX, offsetY);
		Tile[] t = new Tile[l.size()];
		for(int i = 0; i < l.size(); i++) {
			t[i] = new Tile(l.get(i));
		}
		return t;
	}
}
