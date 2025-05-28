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
	                    if (A.x < B.x)
	                        entity.setX(entity.getX() - pen_width);
	                    else
	                        entity.setX(entity.getX() + pen_width);
	                } else {
	                    if (A.y < B.y)
	                        entity.setY(entity.getY() - pen_height);
	                    else
	                        entity.setY(entity.getY() + pen_height);
	                }
	            }
	        }
	    }
	}

}
