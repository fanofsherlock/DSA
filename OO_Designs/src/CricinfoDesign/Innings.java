package CricinfoDesign;

import java.util.List;

public class Innings {

	static final int BOWLS_IN_AN_OVER = 6;

	int currentInnings;
	Team currentTeam;
	MatchFormat format;
	int oversRemaining;
	int bowlsRemaining;
	boolean hasInningsEnded = false;
	Player PlayerOnStrike;
	Player PlayerRunningEnd;

	public Innings(int currentInnings, Team currentPlayingTeam, MatchFormat format) {
		this.currentInnings = currentInnings;
		this.currentTeam = currentPlayingTeam;
		this.format = format;
		oversRemaining = format.getTotalOvers();
		bowlsRemaining = BOWLS_IN_AN_OVER;
	}

	private void startNewOver() {
		if (oversRemaining != 0) {
			// Fresh over
			bowlsRemaining = BOWLS_IN_AN_OVER;
			rotateStrike();

		} else {
			hasInningsEnded = true;
		}
	}

	private void rotateStrike() {
		// rotating strike
		Player temp = PlayerOnStrike;
		PlayerOnStrike = PlayerRunningEnd;
		PlayerRunningEnd = temp;

	}

	public void starInnings() {
		List<Player> openers = currentTeam.getOpeners();
		PlayerOnStrike = openers.get(0);
		PlayerRunningEnd = openers.get(1);

	}

	public void addBowl(BowlTypes bowl) {
		if (bowlsRemaining == 0) {
			startNewOver();
		}

		UpdateTeam(bowl);

		bowlsRemaining -= bowl.getBowlsConsumed();
	}

	private void UpdateTeam(BowlTypes bowl) {
		switch (bowl) {
		case NO_BALL: {
			currentTeam.incrementScore(BowlTypes.NO_BALL.getRunsGiven());
			break;
		}

		case WIDE: {
			currentTeam.incrementScore(BowlTypes.WIDE.getRunsGiven());
			break;
		}

		case DEAD: {
			currentTeam.incrementScore(BowlTypes.DEAD.getRunsGiven());
			break;
		}

		case SINGLE: {
			currentTeam.incrementScore(BowlTypes.SINGLE.getRunsGiven());
			PlayerOnStrike.incrementRunsScored(BowlTypes.SINGLE.getRunsGiven());
			
		}

		}
	}

	public boolean hasInningsEnded() {
		return hasInningsEnded;
	}

}
