package com.sample.spring.project.Learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner_withSpring {
	
	@Autowired
	private GamingConsole game;

	public GameRunner_withSpring(GamingConsole game) {
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
