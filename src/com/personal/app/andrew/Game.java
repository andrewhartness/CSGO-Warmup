package com.personal.app.andrew;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 2205314001445989053L;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 800;
	
	private Thread thread;  //Single threaded
	private boolean running;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "CSGO Warmup", this);
	}
	
	public void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		
		/**
		 *  Game loop credit:  Kevin Glass - Space Invaders
		 */
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)	render();
			frames++;
			
			if(System.currentTimeMillis()- timer > 1000) {
				timer += 1000;
				System.out.println("Frames: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Game();
	}

	
}
