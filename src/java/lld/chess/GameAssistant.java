package lld.chess;

/**
 * Public interface. It will interact with user.
 */
public class GameAssistant {

    Player playerLastPlayed;

    Board board;

    GameAssistant(Board board){

    }

     Piece move(int sX, int sY, int eX, int eY){
        Piece  p = board.getPiece(eX, eY);
        board.movePlayer(sX, sY, eX, eY);
        board.removePiece(eX, eY);
        return p;

    }

    public boolean isValidTurn(Player player){
        return false;
    }

    public boolean isValidPick(Player player, int i, int j){
        return false;
    }

    public boolean isValidMove(int sX, int sY, int eX, int eY){
        // Check if any cordinate is not off the board.
        Piece p = board.getPiece(sX,sY);
        if(p.validSteps(sX, sY, eX, eY) && board.isValidMove(sX, sY, eX, eY))
            return true;

        return false;

    }
}
