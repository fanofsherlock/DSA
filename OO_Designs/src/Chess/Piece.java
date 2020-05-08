package Chess;

abstract class Piece {

	int[][] directions;
	boolean isWhite;
	Position curPosition;

	abstract boolean canMove(Position p);

}
