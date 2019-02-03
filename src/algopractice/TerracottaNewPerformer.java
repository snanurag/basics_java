package algopractice;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Problem statement : There is a party going on. Anyone can join the party at any time and anyone can leave at any time.
 * Participants are allowed to rejoin. A participant would be called on stage to perform. It should be a new participant everytime. Same participant is not allowed to perform again.
 * Performer should be chose from the participants present at any time in party. How can this be executed with minimum complexity.
 */
public class TerracottaNewPerformer {
    static HashSet performedParticipants = new HashSet();
    static HashSet futurePerformers = new HashSet();
    static HashSet participantsPresent = new HashSet();

    public static void perform(){

        futurePerformers.stream().forEach(obj ->{
            if(!futurePerformers.isEmpty()){
                System.out.println(obj);
                futurePerformers.remove(obj);
            }
        });
    }


    public static void main(String[] args) {
        for(int i=0; i<10; i++)
            futurePerformers.add(String.valueOf(i));
        perform();
    }
}
