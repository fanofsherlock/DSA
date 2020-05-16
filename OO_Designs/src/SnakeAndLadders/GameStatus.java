package SnakeAndLadders;

public enum GameStatus {
	NOT_STARTED, ONGOING, FINISHED, ABANDONED;

	String result = this.name();

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
