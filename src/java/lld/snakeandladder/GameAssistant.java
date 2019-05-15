package lld.snakeandladder;

public class GameAssistant {

    private Board board;
    private State state;

    GameAssistant(Board board, State state){

    }

    public void movePlayer(Player player, int diceRoll){
        // Checks if move possible on Board
        // Calculates new possition and checks if hit by ladder or snake.
        //checks new position again if hit by ladder or snake.

        //Check Game state if player already present at new position;
        // If player at new postion then send this player to 0.
    }

    public boolean hasPlayerWon(Player player){
        return state.hasWon(player);
    }

    public boolean isPlayerOutOfTurn(Player player){
        return state.isPlayerOutOfTurn(player);
    }
}
