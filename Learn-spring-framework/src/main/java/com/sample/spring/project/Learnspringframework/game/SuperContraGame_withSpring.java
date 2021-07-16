package com.sample.spring.project.Learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class SuperContraGame_withSpring implements GamingConsole{
	public void up() {
		System.out.println("SuperContra game up");
	}
	
	public void down() {
		System.out.println("down");
	}
	
	public void left() {
		System.out.println("left");
	}
	
	public void right() {
		System.out.println("right");
	}
}
