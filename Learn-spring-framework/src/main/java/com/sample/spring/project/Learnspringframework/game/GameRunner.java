package com.sample.spring.project.Learnspringframework.game;

public class GameRunner {
	private MarioGame game;

	public GameRunner(MarioGame game) {
		super();
		this.game = game;
	}
	
	public void runGame() {
		game.up();
		game.down();
		game.left();
		game.right();
		
	}
	
}
