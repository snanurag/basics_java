package lld.chess;

public class Board {

    Piece[][] board = new Piece[8][8];

    public void initialize(){
        //choose color, type and Moves list, create player and place on board.

    }

    public boolean movePlayer(int sx, int sy, int ex, int ey){
        return false;
    }

    public Piece getPiece(int i, int j){
        return null;
    }
    public boolean isValidMove(int sX, int sY, int eX, int eY){
        // Check If not same color at both positions
        // Check if piece can not hop then no other piece on way.

        return false;
    }

    public void removePiece(int i, int j){

    }



}
