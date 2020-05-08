package Chess;

import java.util.ArrayList;
import java.util.List;

public class Board {
	List<List<Square>> board;

	public Board() {
		initializeBoard();
		setUpWhiteSide();
		setUpBlackSide();
	}

	private void setUpBlackSide() {
		List<Square> frontRow = board.get(1);
		for (int i = 0; i < 8; i++) {
			frontRow.get(i).setCurrentPiece(new Pawn(false));
		}

		List<Square> backRow = board.get(0);
		backRow.get(0).setCurrentPiece(new Rook(false));
		backRow.get(1).setCurrentPiece(new Knight(false));
		backRow.get(2).setCurrentPiece(new Bishop(false));
		backRow.get(3).setCurrentPiece(new Queen(false));
		backRow.get(4).setCurrentPiece(new King(false));
		backRow.get(5).setCurrentPiece(new Bishop(false));
		backRow.get(6).setCurrentPiece(new Knight(false));
		backRow.get(7).setCurrentPiece(new Rook(false));

	}

	private void setUpWhiteSide() {

		List<Square> frontRow = board.get(6);
		for (int i = 0; i < 8; i++) {
			frontRow.get(i).setCurrentPiece(new Pawn(true));
		}

		List<Square> backRow = board.get(7);
		backRow.get(0).setCurrentPiece(new Rook(true));
		backRow.get(1).setCurrentPiece(new Knight(true));
		backRow.get(2).setCurrentPiece(new Bishop(true));
		backRow.get(3).setCurrentPiece(new Queen(true));
		backRow.get(4).setCurrentPiece(new King(true));
		backRow.get(5).setCurrentPiece(new Bishop(true));
		backRow.get(6).setCurrentPiece(new Knight(true));
		backRow.get(7).setCurrentPiece(new Rook(true));
	}

	private void initializeBoard() {
		for (int i = 0; i < 8; i++) {
			ArrayList<Square> row = new ArrayList<>();
			for (int j = 0; j < 8; j++) {
				row.add(new Square());
			}
			board.add(row);
		}
	}

	void updatePosition() {

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
