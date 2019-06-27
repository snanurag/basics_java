package jvm.memorymanagement.stacks;

/**
 * These operations are done at -Xss10m
 *
 * Regardless whether you put one thread of 4 threads, every thread registers same number of add function calls.
 * That means that stack memory is allotted to every thread not process.
 *
 */
public class ChallengeStackLimitOnMultiThreads {
    public static void main(String[] args) {
        final ChallengeStackLimitOnMultiThreads challengeStackLimit = new ChallengeStackLimitOnMultiThreads();
        Runnable r = () -> {
            try{
                challengeStackLimit.add(0);
            }
            catch (Error err){
                System.out.println(err);
            }
        };

        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }

    private void add(int i){
        System.out.println(i);
        // You can un-comment this and try. Every thread prints 100k calls.
//        if(i == 100000) return; // At -Xss10m, threads start failing beyond 100k calls.
        add(++i);
    }
}
