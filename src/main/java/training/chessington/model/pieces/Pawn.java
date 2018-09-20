package training.chessington.model.pieces;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.PlayerColour.*;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> moves = new ArrayList<>();

        if (this.colour.equals(PlayerColour.WHITE)) {
            Move moveUp1 = new Move(from, from.plus(-1, 0));
            moves.add(moveUp1);
            if
        } else if (this.colour.equals(PlayerColour.BLACK)) {
            Move moveDown1 = new Move(from, from.plus(1, 0));
            moves.add(moveDown1);
        }

        return moves;
    }
}
