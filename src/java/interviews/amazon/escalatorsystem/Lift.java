package interviews.amazon.escalatorsystem;

import java.util.List;
import java.util.Set;

public class Lift {

    int level;
    Direction direction;
    List<Request> requests;
    Set<Integer> floors;
    Type type;


    public void queueUpRequest(int level, Direction direction){

    }

    public void servesFloor(int floor){
        floors.add(floor);

    }

    public boolean doesServeFloor(int floor){
        return false;
    }

    public void openGate(){

    }

    public void closeGate(){

    }

    public void checkAndRemoveRequest(){

    }

}
