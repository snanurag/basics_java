package designproblems.thoughtworks;

/**
 * Every fleet has a battleArea which is a int[][] array, which has ships set into the
 * battle area. Also, the strength of the fleet that is the minimum missiles required to destroy
 * the entire fleet.
 *
 */
public class Fleet {


    private int[][] battleArea;
    private int strength;

    /**
     * Creates the battle area, i.e. grid of row x col dimensions.
     *
     * @param row Rows in battle area
     * @param col Columns in battle area
     */
    public Fleet(int row, int col) {
        battleArea = new int[row][col];
    }

    /**
     * Set the ship s into battle area starting from startX and startY indexes.
     *
     * @param s Ship to be placed in fleet
     * @param startX ship X start index
     * @param startY ship Y start index
     */
    public void setShip(Ship s, int startX, int startY) {
        if(battleArea == null) {
            System.err.println("Fleet is not ready.");
            return;
        }
        for (int r = 0; r < s.getHeight(); r++)
            for (int c = 0; c < s.getWidth(); c++){
                int missileRequired = s.getType().equals("Q") ? 2 : 1;
                battleArea[startX + r][startY + c] = missileRequired;
                strength += missileRequired;
            }
    }

    /**
     *  Checks is missile hits the fleet and decrease the strength of the fleet.
     *
     * @param m Missile hit
     * @return Returns true if a missile hits a fleet.
     */
    public boolean hit(Missile m) {
        if(battleArea == null) {
            System.err.println("Fleet is not ready.");
            return false;
        }
        if (battleArea[m.getRow()][m.getCol()] > 0) {
            battleArea[m.getRow()][m.getCol()]--;
            strength--;
            return true;
        }
        return false;
    }

    public int getStrength() {
        return strength;
    }
}
