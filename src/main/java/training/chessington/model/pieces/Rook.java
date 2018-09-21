package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> moves = new ArrayList<>();
        Move moveUp1 = new Move(from, from.plus(-1, 0));
        Move moveUp2 = new Move(from, from.plus(-2, 0));
        Move moveUp3 = new Move(from, from.plus(-3, 0));
        Move moveUp4 = new Move(from, from.plus(-4, 0));
        Move moveUp5 = new Move(from, from.plus(-5, 0));
        Move moveUp6 = new Move(from, from.plus(-6, 0));
        Move moveUp7 = new Move(from, from.plus(-7, 0));


        if (board.get(from.plus(-1, 0)) == null) {
            moves.add(moveUp1);
            moves.add(moveUp2);
            moves.add(moveUp3);
            moves.add(moveUp4);
            moves.add(moveUp5);
            moves.add(moveUp6);
            moves.add(moveUp7);
        }

        return moves;
    }

}
