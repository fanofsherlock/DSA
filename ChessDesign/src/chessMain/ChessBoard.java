package chessMain;

import java.util.ArrayList;
import java.util.List;

import chessPieces.Pawn;
import chessPieces.PieceColor;
import chessPieces.Rook;

public class ChessBoard implements Board {
	List<List<Square>> squares;

	public ChessBoard() {
		initBoard();
		setupBoard();
	}

	private void setupBoard() {
		// setup White

		// White pawns
		List<Square> secRank = squares.get(1);
		for (int i = 0; i < 8; i++) {
			Square curSquare = secRank.get(i);
			curSquare.setCurrentPiece(new Pawn(PieceColor.WHITE));

		}

		// White BackRank
		List<Square> firstRank = squares.get(0);

		// Rooks
		Square curSquare = firstRank.get(0);
		curSquare.setCurrentPiece(new Rook(PieceColor.WHITE));
		curSquare = firstRank.get(7);
		curSquare.setCurrentPiece(new Rook(PieceColor.WHITE));

		// setup Black

		// Black pawns
		List<Square> seventhRank = squares.get(1);
		for (int i = 0; i < 8; i++) {
			curSquare = seventhRank.get(i);
			curSquare.setCurrentPiece(new Pawn(PieceColor.BLACK));

		}

	}

	private void initBoard() {

		for (int i = 0; i < 8; i++) {
			ArrayList<Square> newRank = new ArrayList<Square>();
			squares.add(newRank);
			for (int j = 0; j < 8; j++) {
				newRank.add(new Square());
			}
		}

	}

	class MovePlayer {

		void playMove(Move move) {
             
		}

	}

}
