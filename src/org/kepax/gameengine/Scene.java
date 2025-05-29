package org.kepax.gameengine;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public abstract class Scene {
	List<Entity> entities;
	TileMap tileMap;
	public Scene() {
		entities = new ArrayList<Entity>();
	}
	public abstract void initialize();
	public void addEntity(Entity e) {
		entities.add(e);
	}; 
	public void removeEntity(Entity e) {
		entities.remove(e);
	}
	public void updateEntityPositions() {
		for(Entity e : entities) {
			e.move();
		}
	}
	public void setTileMap(TileMap tm) {
		tileMap = tm;
	}
	public void drawEntities(Graphics g, Camera c) {
		for(Entity e : entities) {
			e.draw(g, c);
		}
	}
	public void drawHitboxes(Graphics g, Camera c) {
		Rectangle tmp;
		for(Entity e : entities) {
			tmp = e.getBoundingBox();
			g.drawRect(tmp.x - c.x, tmp.y - c.y, tmp.width, tmp.height);
		}
	}
	
}
