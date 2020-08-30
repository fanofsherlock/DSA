package chessMain;

public final class Move {
	Piece currentPiece;
	String from;
	String to;

	public Move(Piece currentPiece, String from, String to) {
		super();
		this.currentPiece = currentPiece;
		this.from = from;
		this.to = to;
	}

	public Piece getCurrentPiece() {
		return currentPiece;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

}
