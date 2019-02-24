package algopractice;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Problem statement : There is a party going on. Anyone can join the party at any time and anyone can leave at any time.
 * Participants are allowed to rejoin. A participant would be called on stage to perform. It should be a new participant everytime. Same participant is not allowed to perform again.
 * Performer should be chose from the participants present at any time in party. How can this be executed with minimum complexity.
 */
public class TerracottaNewPerformer {

    //
    static HashSet performedParticipants = new HashSet();
    static HashSet participantsPresent = new HashSet();
    static PriorityQueue<String> futurePerformers = new PriorityQueue<>();

    public static void perform(){
        String name = futurePerformers.poll();
        performedParticipants.add(name);
        System.out.println(name);
    }

    public static void enterInParty(String s){
        if(!performedParticipants.contains(s)){
            futurePerformers.add(s);
        }
        participantsPresent.add(s);
    }

    public static void leaveParty(String s){
        if(!performedParticipants.contains(s))
            futurePerformers.remove(s);
        participantsPresent.remove(s);
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++)
            futurePerformers.add(String.valueOf(i));
        perform();
    }
}
