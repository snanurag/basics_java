package multithreading;

//This shows that threads have local copy of variables. Printing thread "p" has less value than the changing thread "c", which is not possible.
// "p" can have more values than "c" but should not have less value than "c".

public class ThreadLocalCopy {

    int i = 0;
    StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        new ThreadLocalCopy().localfunc();
    }

    void localfunc() {
        new Thread(() -> {
            for (int j = 0; j < 20; j++) {
                stringBuffer.append("c " + ++i +"\n");
                try {
                    Thread.sleep(10);
                } catch (Exception e) {

                }
            }
        }).start();

        new Thread(
                () -> {
                    for (int j = 0; j < 20; j++) {
                        stringBuffer.append("p " +i+ "\n");
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {

                        }
                    }
                    System.out.println(stringBuffer.toString());
                }).start();
    }

}
