package org.kepax.gameengine;
import java.lang.Math;

public class Vector2D {
	private double x_comp, y_comp;
	public Vector2D(double x_comp, double y_comp) {
		this.x_comp = x_comp;
		this.y_comp = y_comp;
	}
	public double getMagnitude() {
		return Math.sqrt(x_comp*x_comp + y_comp*y_comp);
	}
	public static Vector2D getNormalizedVector(Vector2D vec) {
		return new Vector2D(vec.x_comp/vec.getMagnitude(), vec.y_comp/vec.getMagnitude());
	}
	public double getXComponent() {
		return x_comp;
	}
	public double getYComponent() {
		return y_comp;
	}
	public void setXComponent(double x_comp) {
		this.x_comp = x_comp;
	}
	public void setYComponent(double y_comp) {
		this.y_comp = y_comp;
	}
	
}
