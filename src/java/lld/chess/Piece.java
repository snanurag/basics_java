package lld.chess;

import java.util.List;

public class Piece implements IPiece {

    PieceColor type;
    PieceType name;
    boolean hop;

    List<Move> moves;

    Piece(PieceColor type, PieceType name, List<Move> moves){

    }

    public boolean validSteps(int sX, int sY, int eX, int eY){

        //Check if it can move to eX and eY from sX and sY. This check is done across all the moves assigned in the list.
        return false;
    }

}
