package org.kepax.gameengine;

import java.awt.Rectangle;

public class CollisionChecker {
	public static Boolean CollidingAABB(Rectangle A, Rectangle B) {
		int A_left = A.x;
		int B_left = B.x;
		int A_right = A.x + A.width;
		int B_right = B.x + B.width;
		int A_top = A.y;
		int B_top = B.y;
		int B_bottom = B.y + B.height;
		int A_bottom = A.y + A.height;
		return (A_left   < B_right  &&
		A_right  > B_left   &&
		A_top    < B_bottom &&
		A_bottom > B_top);
	}
	public static void resolveCollisionMTV(Entity e1, Entity e2) {
		Rectangle A = e1.getBoundingBox();
		Rectangle B = e2.getBoundingBox();
		int pen_width = (int) ((Math.min(A.x + A.width, B.x + B.width) - Math.max(A.x, B.x)));
		int pen_height = (int) ((Math.min(A.y + A.height, B.y + B.height) - Math.max(A.y, B.y)));
		if (pen_width <= pen_height) {
		    if (B.x < A.x) {
		        e2.setX(e2.getX() - pen_width);
		    } else {
		        e2.setX(e2.getX() + pen_width);
		    }
		} else {
		    if (B.y < A.y) {
		        e2.setY(e2.getY() - pen_height);
		    } else {
		        e2.setY(e2.getY() + pen_height);
		    }
		}
	}
	public static void resolveTileCollision(Entity entity, TileMap tileMap) {
	    int tileSize = tileMap.tileSize;
	    Rectangle A = entity.getBoundingBox();

	    int startCol = (A.x - tileMap.startX) / tileSize;
	    int startRow = (A.y - tileMap.startY) / tileSize;
	    int endCol = (A.x + A.width - tileMap.startX) / tileSize;
	    int endRow = (A.y + A.height - tileMap.startY) / tileSize;

	    for (int i = Math.max(startRow, 0); i <= Math.min(tileMap.height - 1, endRow); i++) {
	        for (int j = Math.max(startCol, 0); j <= Math.min(tileMap.width - 1, endCol); j++) {

	            Tile tile = tileMap.tileSet[tileMap.tileGrid[i][j]];
	            if (tile == null || !tile.isSolid()) continue;

	            Rectangle B = new Rectangle(tileMap.startX + j * tileSize, tileMap.startY + i * tileSize, tileSize, tileSize);

	            A = entity.getBoundingBox();

	            if (CollisionChecker.CollidingAABB(A, B)) {
	                int pen_width = Math.min(A.x + A.width, B.x + B.width) - Math.max(A.x, B.x);
	                int pen_height = Math.min(A.y + A.height, B.y + B.height) - Math.max(A.y, B.y);

	                if (pen_width <= pen_height) {
	                	entity.setVelocityXComponent(0);
	                    if (A.x < B.x)
	                        entity.setX(entity.getX() - pen_width);
	                    else
	                        entity.setX(entity.getX() + pen_width);
	                } else {
	                    if (A.y < B.y) {
	                        entity.setY(entity.getY() - pen_height);
	                    }
	                    else
	                        entity.setY(entity.getY() + pen_height);
	                    entity.setVelocityYComponent(0);
	                }
	            }
	        }
	    }
	}
	public static Boolean collidingWithSolidTile(Entity entity, TileMap tileMap) {
		    int tileSize = tileMap.tileSize;
		    Rectangle A = entity.getBoundingBox();

		    int startCol = (A.x - tileMap.startX) / tileSize;
		    int startRow = (A.y - tileMap.startY) / tileSize;
		    int endCol = (A.x + A.width - tileMap.startX) / tileSize;
		    int endRow = (A.y + A.height - tileMap.startY) / tileSize;

		    for (int i = Math.max(startRow, 0); i <= Math.min(tileMap.height - 1, endRow); i++) {
		        for (int j = Math.max(startCol, 0); j <= Math.min(tileMap.width - 1, endCol); j++) {

		            Tile tile = tileMap.tileSet[tileMap.tileGrid[i][j]];
		            if (tile == null || !tile.isSolid()) continue;

		            Rectangle B = new Rectangle(tileMap.startX + j * tileSize, tileMap.startY + i * tileSize, tileSize, tileSize);

		            A = entity.getBoundingBox();

		            if (CollisionChecker.CollidingAABB(A, B)) {
		                return true;
		            }
		        }
		    }
		    return false;
	}
	public static Boolean isAboveSolidTile(Entity entity, TileMap tileMap) {
		Rectangle r = entity.getBoundingBox();
		int row = (r.y + r.height) / tileMap.tileSize;
		int startCol = Math.max(0, r.x / tileMap.tileSize);
		int endCol = Math.min((r.x + r.width) / tileMap.tileSize, tileMap.width - 1);
		if(row*tileMap.tileSize != r.y + r.height || row < 0 || row >= tileMap.height) return false;
		for(int col = startCol; col <= endCol; col++) {
			if(tileMap.tileSet[tileMap.tileGrid[row][col]].isSolid()) return true;
		}
		return false;
	}
	public static Boolean isBelowSolidTile(Entity entity, TileMap tileMap) {
		Rectangle r = entity.getBoundingBox();
		int row = (r.y) / tileMap.tileSize - 1;
		int startCol = Math.max(0, r.x / tileMap.tileSize);
		int endCol = Math.min((r.x + r.width) / tileMap.tileSize, tileMap.width - 1);
		if((row+1)*tileMap.tileSize != r.y || row < 0 || row >= tileMap.height) return false;
		System.out.println(row + " " + startCol + " " + endCol);
		for(int col = startCol; col <= endCol; col++) {
			if(tileMap.tileSet[tileMap.tileGrid[row][col]].isSolid()) return true;
		}
		return false;
	}
	public static Boolean isLeftOfSolidTile(Entity entity, TileMap tileMap) {
		Rectangle r = entity.getBoundingBox();
		int col = (r.x + r.width) / tileMap.tileSize;
		int startRow = Math.max(0, r.y / tileMap.tileSize);
		int endRow = Math.min((r.y + r.height) / tileMap.tileSize, tileMap.height - 1);
		if(col*tileMap.tileSize != r.x + r.width || col < 0 || col >= tileMap.height) return false;
		for(int row = startRow; row <= endRow; row++) {
			if(tileMap.tileSet[tileMap.tileGrid[row][col]].isSolid()) return true;
		}
		return false;
	}
	public static Boolean isRightOfSolidTile(Entity entity, TileMap tileMap) {
		Rectangle r = entity.getBoundingBox();
		int col = (r.x) / tileMap.tileSize - 1;
		int startRow = Math.max(0, r.y / tileMap.tileSize);
		int endRow = Math.min((r.y + r.height) / tileMap.tileSize, tileMap.height - 1);
		if((col+1)*tileMap.tileSize != r.x || col < 0 || col >= tileMap.width) return false;
		for(int row = startRow; row <= endRow; row++) {
			if(tileMap.tileSet[tileMap.tileGrid[row][col]].isSolid()) return true;
		}
		return false;
	}
}
