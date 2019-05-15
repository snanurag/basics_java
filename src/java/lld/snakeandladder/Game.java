package lld.snakeandladder;

import lld.snakeandladder.exceptions.PlayerOutOfTurnException;

import java.util.List;

public class Game {

    List<Player> players;
    GameAssistant gameAssistant;
    Board board;

    public Game(int squares, int[][] snakes, int[][] ladders){
        Board board = new Board(squares, snakes, ladders);
    }

    public void registerPlayers(String player){
        players.add(new Player(player));
    }

    public void startGame(){
        // Create players list
        State state = new State(this.players);
        gameAssistant = new GameAssistant(board, state);
    }

    public void play(Player player) {
        //If player is out of turn then display msg

        int diceRoll = Dice.rollDice();
        gameAssistant.movePlayer(player, diceRoll);
        if(gameAssistant.hasPlayerWon(player)){
            displayPlayerWonMessage(player);
            players.remove(player);
        }

        // If players list empty display game over message.

    }

    public ScoreBoard displayScoreBoard(){
        //Returns the current score board which stores list of winners
        return null;
    }

    private Message displayGameOverMessage(){
        return null;
    }

    private Message displayPlayerWonMessage(Player player){
        return null;
    }

    private Message displayoutOfTurnPlayMsg(Player player){
        return null;
    }

}
