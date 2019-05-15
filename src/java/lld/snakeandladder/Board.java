package lld.snakeandladder;

public class Board {

    LaddersAndSnakes ladders;
    LaddersAndSnakes snakes;
    int squares;

    public Board(int squares, int[][] snakes, int[][] ladders){
    }

    public boolean isMovePossible(int start, int diceroll){
        // checks if start + diceroll doesn't go beyond squares size
        return false;
    }

    public boolean isHitByLadder(int pos){
        return false;
    }

    public int getNewClimbPos(int pos){
        return 0;
    }

    public boolean isHitBySnake(int pos){
        return false;
    }

    public int getNewFallPosition(int pos){
        return 0;
    }
}
