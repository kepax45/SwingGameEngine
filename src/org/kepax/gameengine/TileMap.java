package org.kepax.gameengine;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TileMap {
	int[][] tileGrid;
	Tile[] tileSet;
	int tileSize;
	int width, height;
	int startX, startY;
	
	private TileMap(int[][] tileGrid, Tile[] tileSet, int tileSize) {
		this.tileGrid = tileGrid;
		this.tileSet = tileSet;
		this.tileSize = tileSize;
	}
	
	public static TileMap loadTileMap(String filePath, Tile[] tileSet, int tileSize, int startX, int startY) {
		File f = new File(filePath);
		int width = 0, height = 0;
		int[][] tileGrid = null;
		try {
			Scanner fileReader = new Scanner(f);
			width = fileReader.nextInt();
			height = fileReader.nextInt();
			tileGrid = new int[height][width];
			int cnt = 0;
			while(cnt < width * height && fileReader.hasNextInt()) {
				tileGrid[cnt / width][cnt % width] = fileReader.nextInt();
				cnt++;
			}
			System.out.println(cnt);
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		TileMap t = new TileMap(tileGrid, tileSet, tileSize);
		t.height = height;
		t.width = width;
		t.startX = startX;
		t.startY = startY;
		return t;
	}
	public void drawTileMap(Graphics g, Camera c) {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				g.drawImage(tileSet[tileGrid[i][j]].image, startX + j*tileSize - c.x, startY + i*tileSize - c.y, null);
			}
		}
	}
	
	
	
}
