package com.sample.spring.project.Learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sample.spring.project.Learnspringframework.game.GameRunner;
import com.sample.spring.project.Learnspringframework.game.GameRunner_withSpring;
import com.sample.spring.project.Learnspringframework.game.GamingConsole;
import com.sample.spring.project.Learnspringframework.game.MarioGame;
import com.sample.spring.project.Learnspringframework.game.SuperContraGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {

		/*
		 * ...lossley coupled using interface alone../ // GamingConsole game=new
		 *SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		 * MarioGame(); GamingConsole game=new SuperContraGame(); GameRunner runner=new
		 * GameRunner(game); runner.runGame(); ,by changing the class name alone as you
		 * create game object will work here,no need to modify the GameRunner
		 * class.That's why it is called loosely coupled
		 */
		
		// Loosly coupled with Spring.
		
		ConfigurableApplicationContext context = 
				SpringApplication.run(LearnSpringFrameworkApplication.class, args);

		
		GameRunner_withSpring runner = context.getBean(GameRunner_withSpring.class);
		runner.runGame();
		/* Creating only the object of GameRunner and calling runGame.
		 * Rest will be handled by sprint.we are not creating object of mariogame 
		 * but we have autowired Gamerunner class to interface Gamingconsole.
		 */
	}

}