package CricinfoDesign;

public class Player {
	String name;
	Team team;
	int runsScored;
	int Fours;
	int Sixes;
	int ballsFaced;
	InningStatus status;

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getFours() {
		return Fours;
	}

	public void incrementFours() {
		Fours++;
	}

	public int getSixes() {
		return Sixes;
	}

	public void incrementSixes() {
		Sixes++;
	}

	public int getBallsFaced() {
		return ballsFaced;
	}

	public void incrementBallsFaced() {
		ballsFaced++;
	}

	public void incrementRunsScored(int num) {
		runsScored += num;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public InningStatus getStatus() {
		return status;
	}

	public void setStatus(InningStatus status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Player other = (Player) obj;

		return this.getTeam().equals(other.getTeam());

	}

	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}

}
