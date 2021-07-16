package com.sample.spring.project.Learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame_withSpring implements GamingConsole {
	
	@Override
	public void up() {
		System.out.println("jump");
	}
	
	@Override
	public void down() {
		System.out.println("go in to a hole");
	}
	
	@Override
	public void left() {
		System.out.println("stop");
	}
	
	@Override
	public void right() {
		System.out.println("go faster");
	}

}
