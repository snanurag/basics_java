package designproblems.thoughtworks;

public class Missile {

    private int row = 0;
    private int col = 0;
    private String location;

    public Missile(String s) {
        location = s;
        int[] indices = Util.convertIntoRowCol(s);
        row = indices[0];
        col = indices[1];
    }

    public int getRow() {
        return row;
    }

   public int getCol() {
        return col;
    }

    public String getLocation(){
        return location;
    }
}
