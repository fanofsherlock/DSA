package CricinfoDesign;

public class ScoreBoard {

	Team teamA;
	Team teamB;
	Team currentPlayingTeam;
	Innings currentInnings;
	int inningNumber;
	MatchFormat format;

	private ScoreBoard(ScoreboardBuilder builder) {
		teamA = builder.teamA;
		teamB = builder.teamB;
		format = builder.format;
	}

	static class ScoreboardBuilder {
		Team teamA;
		Team teamB;
		MatchFormat format;

		public ScoreboardBuilder() {
		}

		ScoreboardBuilder firstTeam(Team a) {
			teamA = a;
			return this;
		}

		ScoreboardBuilder secondTeam(Team b) {
			teamB = b;
			return this;
		}

		ScoreboardBuilder matchType(MatchFormat format) {
			this.format = format;
			return this;
		}

		public ScoreBoard build() {
			return new ScoreBoard(this);
		}

	}

	public String getCurrentMatchStats() {
		return currentPlayingTeam.toString();
	}

	public String getMatchResult() {
		StringBuilder sb = new StringBuilder();

		sb.append(teamA.toString() + "\n\n");
		sb.append(teamB.toString());

		return sb.toString();
	}

	public void startNewInnings() {
		inningNumber++;

		if (inningNumber % 2 == 1) {
			currentPlayingTeam = teamA;

		} else if (inningNumber % 2 == 0) {
			currentPlayingTeam = teamB;

		} else if (inningNumber > format.getTotalInnings()) {
			// throw exception;
		}

		Innings inning = new Innings(inningNumber, currentPlayingTeam, format);
		inning.starInnings();

	}

	public void addBowl(BowlTypes bowl) {
		currentInnings.addBowl(bowl);
	}

}
