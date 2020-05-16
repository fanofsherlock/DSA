package SnakeAndLadders;

import java.util.Deque;
import java.util.Optional;

public class Game {
	Board board;
	Deque<Player> players;
	Dice dice;
	GameStatus status;

	void startGame() {
		while (status != GameStatus.FINISHED) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			nextTurn();
		}
	}

	void nextTurn() {
		Player curPlayer = players.poll();
		int dice_roll = dice.roll();
		movePlayer(curPlayer, dice_roll);
		if (hasWonGame(curPlayer)) {
			status = GameStatus.FINISHED;
			status.setResult(curPlayer.name + " has Won");
		}

		players.add(curPlayer);
	}

	private boolean hasWonGame(Player curPlayer) {
		return curPlayer.position == board.size;
	}

	private void movePlayer(Player curPlayer, int dice_roll) {
		int posPosition = curPlayer.position + dice_roll;

		Optional<Snake> posSnake = board.getPossibleSnake(posPosition);
		if (posSnake.isPresent()) {
			posPosition = posSnake.get().tail;
		}

		Optional<Ladder> posLadder = board.getPossibleLadder(posPosition);
		if (posLadder.isPresent()) {
			posPosition = posLadder.get().top;
		}

		curPlayer.position = posPosition;
	}

	class GameMemento {
		Board board;
		Deque<Player> players;
		Dice dice;
		String result;
		GameStatus status = GameStatus.NOT_STARTED;

		GameMemento() {
			this.board = Game.this.board;
			this.players = Game.this.players;
			this.dice = Game.this.dice;
			this.status = Game.this.status;
		}
	}

	GameMemento saveGame() {
		return new GameMemento();
	}

	void reloadGame(GameMemento memento) {
		Game.this.board = memento.board;
		Game.this.players = memento.players;
		Game.this.dice = memento.dice;
		Game.this.status = memento.status;
	}
}
