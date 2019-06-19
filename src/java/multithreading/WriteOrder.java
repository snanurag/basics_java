package multithreading;

public class WriteOrder {
    int a, b = 0;

    public static void main(String[] args) {
        new WriteOrder().method();

    }

    private void method() {
        while (true) {
            new Thread(() -> {
                a = 1;
                b = 2;
            }).start();
            if (a == 0 && b == 2) {
                System.out.println(a + " "+ b);
                System.out.println("Read order is not same as write order");
                break;
            }
            System.out.println(a + " " + b);
            a = 0;
            b = 0;
        }
    }
}
