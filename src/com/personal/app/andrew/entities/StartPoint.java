package com.personal.app.andrew.entities;

import java.awt.Color;
import java.awt.Graphics;

import com.personal.app.andrew.ID;

public class StartPoint extends GameEntity {

	public StartPoint(int x, int y, ID id) {
		super(x, y, id);
		
	}

	
	public void update() {
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x-25, y-25, 50, 50);
		
		g.setColor(Color.black);
		g.drawOval(x-25, y-25, 50, 50);
	}
	

	
}
