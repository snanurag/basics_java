package annotations;

public class MainClass {

    @SQLString //@SimulatingNull				//TODO Remove the comments to see that each attribute should be defined.
    public void setIt() {

    }

    @SQLString
    @SimulatingNull(description = "")
    public void setIt2() {

    }
}