package lld.snakeandladder;

import java.util.List;

public class State {

    List<Player> players;
    int playerLastPlayed;

    State(List<Player> players){

    }
    boolean isPositionOccupied(int pos){
        // return if board is occupied
        return false;
    }

    boolean hasWon(Player name){
        return false;
    }

    boolean isPlayerOutOfTurn(Player player){
        return false;
    }
}
