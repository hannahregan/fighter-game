package testing;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Enemy {
	public int x,y;
	public Shape rect;
	public int bounce = 1;
	public int bounceCount = 0;
	public boolean hasKilled = false;
	
	public Enemy() {
		this.x = 12;
		this.y = 12;
		rect = new Circle(this.x + 50, this.y - 50, 100);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
