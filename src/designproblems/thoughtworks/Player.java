package designproblems.thoughtworks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This player fires missile on opposition player. Once it fires the missile, it communicates to the opposition.
 * Once opposition comes to know about the missile being fire at its fleet, it calculates the casualty.
 * If any casualty then it communicates back. If no casualty then it fires the missile.
 * If player comes to know about successful hit, it fires again.
 */

public class Player {

    private Queue<Missile> missles = new LinkedList<>();
    private Fleet fleet;
    private Player opposition;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    /**
     * Fires the missile and communicates to the opposition.
     */
    public void fireMissile() {

        if (opposition == null) throw new RuntimeException("Player is not ready for the Battle");

        Missile m = missles.poll();
        opposition.consumeMissile(m);
    }

    /**
     * Receives the missiles and calculates casualty. On successful hit, notify opposition otherwise fire missile.
     * @param m Missile
     */
    public void consumeMissile(Missile m) {

        if (opposition == null) throw new RuntimeException("Player is not ready for the Battle");

        if (m == null && missles.peek() == null) {
            Util.outBuff.append(String.format(Constants.DRAW));
            return;
        }

        if (m != null) {
            if (fleet.hit(m)) {
                Util.outBuff.append(String.format(Constants.FIRE, opposition.name, m.getLocation(), "hit"));
                if (fleet.getStrength() == 0) Util.outBuff.append(String.format(Constants.WIN, opposition.name));
                else opposition.notifySuccess();
            } else {

                Util.outBuff.append(String.format(Constants.FIRE, opposition.name, m.getLocation(), "miss"));
                fireMissile();
            }

        } else {
            Util.outBuff.append(String.format(Constants.EMPTY, opposition.name));
            fireMissile();
        }

    }

    /**
     * It will create the fleet of the player.
     *
     * @param row rows in fleet
     * @param col columns in fleet
     * @return Fleet of the playerß
     */
    public Fleet createFleet(int row, int col) {
        fleet = new Fleet(row, col);
        return fleet;
    }

    /**
     * Will be notified by the opposition player if the missile hits the target.
     */
    private void notifySuccess() {
        fireMissile();
    }

    public void setOpposition(Player opposition) {
        this.opposition = opposition;
    }

    public void setMissles(String location) {
        Missile m = new Missile(location);
        missles.add(m);
    }
}
