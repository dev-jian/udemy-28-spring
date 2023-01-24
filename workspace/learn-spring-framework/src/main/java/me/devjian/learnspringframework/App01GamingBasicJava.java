package me.devjian.learnspringframework;

import me.devjian.learnspringframework.game.GameRunner;
import me.devjian.learnspringframework.game.MarioGame;
import me.devjian.learnspringframework.game.PacmanGame;
import me.devjian.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
//		var marioGame = new MarioGame();
//		var superContraGame = new SuperContraGame();
		var pacmanGame = new PacmanGame();				// 1: Object Create
		var gameRunner = new GameRunner(pacmanGame); 	// 2: Object Create + Wiring of Dependencies.
		
		gameRunner.run();
	}

}
