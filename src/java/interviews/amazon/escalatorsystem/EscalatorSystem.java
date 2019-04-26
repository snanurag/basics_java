package interviews.amazon.escalatorsystem;

import java.util.List;

/**
 * Design an escalator system.
 */
public class EscalatorSystem {

    List<Lift> list;

    Authentication authentication;
    Intercom intercom;


    public void requestLift(int level, Direction direction){
        //Whichever is close and same direction
        // else stationary Lift
        // else whichever is far and opp direction
        Lift l = null;

        l.queueUpRequest(level, direction);

    }

    public boolean authenticate(Long key){
        //
        return false;
    }

    public void intercomConnection(int floor, int flat){

    }

    public void openEscalator(){

    }

    public void createEscalator(int lift, int floor, Policy floorPolicy){

    }


}
