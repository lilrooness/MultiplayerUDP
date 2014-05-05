package game.sync;

import game.Game;

import java.util.TimerTask;

public class GameUpdateTimerTask extends TimerTask {
	
	private Game game;

	public GameUpdateTimerTask(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void run() {
		game.tick();
	}

}
