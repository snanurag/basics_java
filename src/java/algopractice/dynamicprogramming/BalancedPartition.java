package algopractice.dynamicprogramming;

public class BalancedPartition {

    static boolean[] markerArray;

    static int[] originalArray = {87, 100, 28, 67, 68, 41, 67, 1};

    static int halfSum;

    static int lastStoredSum;

    static boolean[] lastStoredCopy;

    public static void main(String[] args) {
        markerArray = new boolean[originalArray.length];
        halfSum = getTotalSum() / 2;
        recursiveFunction();
        printArray(lastStoredCopy);

    }

    private static void recursiveFunction() {
        for (int i = 0; i < markerArray.length; i++) {
            if (!markerArray[i]) {
                markerArray[i] = true;
                int tmpSum = getSum();
                if (tmpSum > halfSum) {
                    tmpSum -= originalArray[i];
                    markerArray[i] = false;
                } else if (tmpSum < halfSum) {
                    recursiveFunction();
                }
                if (tmpSum <= halfSum && tmpSum > lastStoredSum) {
                    lastStoredSum = tmpSum;
                    lastStoredCopy = markerArray.clone();
                }

                markerArray[i] = false;
            }
        }
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < markerArray.length; i++) {
            if (markerArray[i]) {
                sum += originalArray[i];
            }
        }

        return sum;
    }

    private static int getTotalSum() {
        int sum = 0;
        for (int i = 0; i < markerArray.length; i++) {
            sum += originalArray[i];
        }

        return sum;

    }

    private static void printArray(boolean[] array) {
        for (boolean b : array) {
            System.out.print(b + " ");
        }
    }
}
