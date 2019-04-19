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
            if (startEventExists(rId)) {
                writeToLogger(ts);
            } else {
                storeToMap(rId, ts);
                return;
            }
            while (nextStartAndEndEventPairMatch()) {
                writeToLogger();
            }
        }
    }

    boolean startEventExists(int rId) {
        StartEvent e = queue.peek();
        return e!=null && e.reqId == rId;
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

    boolean nextStartAndEndEventPairMatch() {
        StartEvent s = queue.peek();
        if(s!= null){
            Long ts = map.get(s.reqId);
            if (ts != null) return true;
        }
        return false;
    }

    void storeToMap(int reqId, long ts){
        map.put(reqId, ts);
    }

    public static void main(String[] args) {

        //Some basic tests on Java Apis.
        StartEvent s = new LoggerAPI().queue.peek();
        System.out.println(s);  //null

        Long l = new LoggerAPI().map.get("a");
        long a = l; //NullPointerException
        System.out.println(l);
        System.out.println(a);
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

