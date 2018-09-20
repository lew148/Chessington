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
        Move moveUp1 = new Move(from, from.plus(-1, 0));
        Move moveUp2 = new Move(from, from.plus(-2, 0));
        Move moveDown1 = new Move(from, from.plus(1, 0));
        Move moveDown2 = new Move(from, from.plus(2, 0));
        Move moveDiagonalUpRight = new Move(from, from.plus(-1,1));
        Move moveDiagonalUpLeft = new Move(from, from.plus(-1, -1));
        Move moveDiagonalDownRight = new Move(from, from.plus(1, 1));
        Move moveDiagonalDownLeft = new Move(from, from.plus(1, -1));


        if (this.colour.equals(PlayerColour.WHITE)) {

            if (from.getRow() != 0) {
                if (board.get(from.plus(-1, 0)) == null) {
                    if (from.getRow() == 6) {
                        moves.add(moveUp1);
                        moves.add(moveUp2);
                    } else {
                        moves.add(moveUp1);
                    }
                }
                if (from.getCol() != 0 && from.getCol() != 7) {
                    if (board.get(from.plus(-1, 1)) != null || board.get(from.plus(-1, -1)) != null) {
                        if (board.get(from.plus(-1, 1)) != null && board.get(from.plus(-1, 1)).getColour() != PlayerColour.WHITE) {
                            moves.add(moveDiagonalUpRight);
                        }
                        if (board.get(from.plus(-1, -1)) != null && board.get(from.plus(-1, -1)).getColour() != PlayerColour.WHITE) {
                            moves.add(moveDiagonalUpLeft);
                        }
                    }
                } else if (from.getCol() == 0) {
                    if (board.get(from.plus(-1, 1)) != null && board.get(from.plus(-1, 1)).getColour() != PlayerColour.WHITE) {
                        moves.add(moveDiagonalUpRight);
                    }
                } else if (from.getCol() == 7) {
                    if (board.get(from.plus(-1, -1)) != null && board.get(from.plus(-1, -1)).getColour() != PlayerColour.WHITE) {
                            moves.add(moveDiagonalUpLeft);
                    }
                }
            }


        } else if (this.colour.equals(PlayerColour.BLACK)) {

            if (from.getRow() != 7) {
                if (board.get(from.plus(1, 0)) == null) {
                    if (from.getRow() == 1) {
                        moves.add(moveDown1);
                        moves.add(moveDown2);
                    } else {
                        moves.add(moveDown1);
                    }
                }
                if (from.getCol() != 0 && from.getCol() != 7) {
                    if (board.get(from.plus(1, 1)) != null || board.get(from.plus(1, -1)) != null) {
                        if (board.get(from.plus(1, 1)) != null && board.get(from.plus(1, 1)).getColour() != PlayerColour.BLACK) {
                            moves.add(moveDiagonalDownRight);
                        }
                        if (board.get(from.plus(1, -1)) != null && board.get(from.plus(1, -1)).getColour() != PlayerColour.BLACK) {
                            moves.add(moveDiagonalDownLeft);
                        }
                    }
                } else if (from.getCol() == 0) {
                    if (board.get(from.plus(1, 1)) != null && board.get(from.plus(1, 1)).getColour() != PlayerColour.BLACK) {
                        moves.add(moveDiagonalDownRight);
                    }
                } else if (from.getCol() == 7) {
                    if (board.get(from.plus(1, -1)) != null && board.get(from.plus(1, -1)).getColour() != PlayerColour.BLACK) {
                        moves.add(moveDiagonalDownLeft);
                    }
                }
            }
        }

        return moves;
    }
}
