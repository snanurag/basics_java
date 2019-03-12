package designproblems.thoughtworks;

/**
 * Ship
 */
public class Ship {

    private String type = null;
    private int width = 0;
    private int height = 0;

    public Ship(String type, int w, int h){
        this.type =  type;
        width = w;
        height = h;
    }

    public String getType() {
        return type;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
