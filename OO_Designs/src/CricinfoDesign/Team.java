package CricinfoDesign;

import java.util.ArrayList;
import java.util.List;

public class Team {
	String name;
	String description;
	MatchFormat teamType;
	int nextPlayerNumber;
	List<Player> Players;
	int score;
	int wickets;

	public Team(String name, String description, MatchFormat teamType) {
		super();
		this.name = name;
		this.description = description;
		this.teamType = teamType;

		Players = new ArrayList<Player>();
	}

	void addPlayer(Player p) {
		Players.add(p);
	}

	void removePlayer(Player p) {
		Players.remove(p);
	}

	public List<Player> getOpeners() {
		List<Player> openers = new ArrayList<>();
		openers.add(Players.get(0));
		openers.add(Players.get(1));
		nextPlayerNumber = 2;
		return openers;

	}

	public Player getNextPlayer() {
		if (nextPlayerNumber >= Players.size()) {
			return null;
		}
		Player p = Players.get(nextPlayerNumber);
		nextPlayerNumber++;
		return p;
	}

	public void incrementScore(int num) {
		score += num;
	}

	public void incrementWickets() {
		wickets++;
	}
}
