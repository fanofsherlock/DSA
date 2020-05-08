package Chess;

import java.util.List;

public abstract class Player {

	List<Move> moves;

	void makeAMove(Move m) {
		if (m.movePiece.canMove(m.moveTo)) {
			moves.add(m);
		}
	}
}
