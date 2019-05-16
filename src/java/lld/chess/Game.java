package lld.chess;

public class Game {

    Player p1;
    Player p2;
    Player currentPlayer;

    Board board;
    GameAssistant gameAssistant;

    public void registerPlayer(String name, PieceColor pieceColor) throws ChessException {
        // If player has already taken color then throw message;
    }

    public void pickPlayer(String name){

    }

    public void createGameBoard(){
        board = new Board();
        board.initialize();
        gameAssistant = new GameAssistant(board);
    }

    public void movePiece(int sX, int sY, int ex, int ey) throws ChessException{
        if(!gameAssistant.isValidTurn(currentPlayer)) throw new ChessException("Invalid turn");
        if(gameAssistant.isValidPick(currentPlayer, sX, sY)) throw new ChessException("Wrong piece picked");
       // if(gameAssistant.isValidMove()) throw exception
        // Piece p = gameAssistant.move()
        // if p is of type KING then display currentPlayerWon
        // else display other players turn.
    }

    private void displayTurn(){

    }
    private void displayWon(Player p){

    }
}
