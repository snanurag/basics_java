package interviews.google;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Apr 19
 *
 * Write the startEvent and endEvent functions of LoggerAPI.
 * Logging to logs should be in start event order only.
 *
 */
public class LoggerAPI {
    PriorityQueue<StartEvent> queue = new PriorityQueue<>();
    Map<Integer, Long> map = new HashMap<>();

    void startEvent(int reqId, Long ts) {
        queue.add(new StartEvent(reqId, ts));
    }

    void endEvent(int rId, Long ts) {
        synchronized (queue){
            if (startEventExists()) {
                writeToLogger(ts);
            } else {
                storeToMap(rId, ts);
                return;
            }
            while (startEventExists() && endEventExists()) {
                writeToLogger();
            }
        }
    }

    boolean startEventExists() {
        return queue.peek() != null;
    }

    void writeToLogger(Long ts) {
        StartEvent s = queue.poll();
        System.out.println(s.reqId + " " + s.ts + " " + ts);
    }

    void writeToLogger(){
        StartEvent s = queue.poll();
        Long ts = map.remove(s.reqId);
        System.out.println(s.reqId + " " + s.ts + " " + ts);
    }

    boolean endEventExists() {
        StartEvent s = queue.peek();
        Long ts = map.get(s.reqId);
        if (ts == 0) return false;
        return true;
    }

    void storeToMap(int reqId, long ts){
        map.put(reqId, ts);
    }

}

class StartEvent implements Comparator {
    int reqId = 0;
    Long ts = 0L;

    StartEvent(int reqId, Long ts) {
        this.ts = ts;
        this.reqId = reqId;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 == null || o2 == null) return 0;
        return Long.compare(((StartEvent) o1).ts, ((StartEvent) o2).ts);
    }
}

