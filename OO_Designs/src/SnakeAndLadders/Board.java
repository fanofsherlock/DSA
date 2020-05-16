package SnakeAndLadders;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Board {
	int size;
	Deque<Player> boardPlayers;
	List<Snake> snakes;
	List<Ladder> ladders;

	private Board(BoardBuilder builder) {
		size = builder.size;
		boardPlayers = builder.boardPlayers;
		snakes = builder.snakes;
		ladders = builder.ladders;
	}

	static class BoardBuilder {

		int size;
		Deque<Player> boardPlayers;
		List<Snake> snakes;
		List<Ladder> ladders;

		public BoardBuilder(int size) {
			this.size = size;
		}

		BoardBuilder setSnakes(List<Snake> snakes) {
			this.snakes = snakes;
			return this;
		}

		BoardBuilder setLadders(List<Ladder> ladders) {
			this.ladders = ladders;
			return this;
		}

		BoardBuilder setPlayers(List<Player> players) {
			boardPlayers = new LinkedList<Player>(players);
			return this;
		}

		Board build() {
			return new Board(this);
		}

	}

	public Optional<Snake> getPossibleSnake(int posPosition) {
		return snakes.parallelStream().filter(e -> e.head == posPosition).findAny();
	}

	public Optional<Ladder> getPossibleLadder(int posPosition) {
		return ladders.parallelStream().filter(e -> e.bottom == posPosition).findAny();
	}

}
