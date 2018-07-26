package com.personal.app.andrew;

import java.awt.Graphics;
import java.util.LinkedList;

import com.personal.app.andrew.entities.GameEntity;

public class Handler {

	LinkedList<GameEntity> entities = new LinkedList<>();
	
	private Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public void addEntity(GameEntity entity) {
		this.entities.add(entity);
	}
	
	public void RemoveEntity(GameEntity entity) {
		this.entities.remove(entity);
	}
	
	public void update() {
		for(int i=0; i < entities.size(); i++) {
			GameEntity temp = entities.get(i);
			
			temp.update();
		}
	}
	
	public void render(Graphics g) {
		for(int i=0; i < entities.size(); i++) {
			GameEntity temp = entities.get(i);
			
			temp.render(g);
		}
	}
}
