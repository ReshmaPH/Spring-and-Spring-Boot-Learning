package com.sample.spring.project.Learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sample.spring.project.Learnspringframework.game.GameRunner;
import com.sample.spring.project.Learnspringframework.game.MarioGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		MarioGame game=new MarioGame();
		GameRunner runner=new GameRunner(game);
		runner.runGame();
		/*The above code works now but if you want to run SuperContraGame,by changing just the object
		 * (SuperContraGame game=new SuperContraGame) alone wouldn't work as the code is tightly coupled here.
		 * In order to work that you have to modify the GameRunner class also and change the member variable
		 *  game to SuperContraGame type instead of MarioGame.
		 */
	}

}

