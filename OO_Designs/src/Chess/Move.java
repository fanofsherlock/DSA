package Chess;

public class Move {

	Piece movePiece;
	Position moveTo;

	public Move(Piece movePiece, Position moveTo) {
		super();
		this.movePiece = movePiece;
		this.moveTo = moveTo;
	}

}
