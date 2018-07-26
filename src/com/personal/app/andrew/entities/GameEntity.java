package com.personal.app.andrew.entities;

import java.awt.Graphics;

import com.personal.app.andrew.ID;

public abstract class GameEntity {
	
	protected int x, y;
	protected ID id;
	
	public GameEntity(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);

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

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	
	

}
