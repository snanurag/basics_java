package designproblems.thoughtworks;

import java.util.List;

public class Data {
    private int row;
    private int cols;
    private List<String[]> battleShips;
    private String[] attacksOfP1;
    private String[] attacksOfP2;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public List<String[]> getBattleShips() {
        return battleShips;
    }

    public void setBattleShips(List<String[]> battleShips) {
        this.battleShips = battleShips;
    }

    public String[] getAttacksOfP1() {
        return attacksOfP1;
    }

    public void setAttacksOfP1(String[] attacksOfP1) {
        this.attacksOfP1 = attacksOfP1;
    }

    public String[] getAttacksOfP2() {
        return attacksOfP2;
    }

    public void setAttacksOfP2(String[] attacksOfP2) {
        this.attacksOfP2 = attacksOfP2;
    }
}
