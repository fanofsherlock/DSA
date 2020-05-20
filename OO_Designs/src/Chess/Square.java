package Chess;

public class Square {

	Piece currentPiece;

	public Piece getCurrentPiece() {
		return currentPiece;
	}

	public void setCurrentPiece(Piece currentPiece) {
		this.currentPiece = currentPiece;
	}

	public void resetBoard() {
		currentPiece = null;
	}

}
