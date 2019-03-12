package algos;

/**
 * This code works only for the unique number of entries in the given sample
 * input. For duplicate entries, it could be modified.
 */
public class Combinations {

    private static int[] a;

    public static void main(String[] args) {
        findnCr(7, 4);

    }

    public static void findnCr(int n, int r) {
        a = new int[n];
        for (int i = 0; i < r; i++) {
            a[i] = 1;
        }
        combination(1, 1, n - r + 1);
    }

    /**
     * This function prints all the possible combinations of the array. On every
     * new combination it calls the notify method.
     *
     * @param currentPos
     * @param start
     * @param end
     */
    private static void combination(int currentPos, int start, int end) {
        if (end > a.length) {
            end = 1;
        }

        for (int i = start; i <= end; i++) {

            // if condition is for the movement of all the positions but the
            // last position in the array.
            if (end != a.length) {
                if (i != currentPos) {
                    a[i - 1] += 1;
                    a[currentPos - 1] -= 1;
                    currentPos = i;
                }
                combination(currentPos + 1, i + 1, end + 1);
            }
            // else condition is for the movement of the last value in the
            // array.
            else {
                if (i != currentPos) {
                    a[i - 1] += 1;
                    a[currentPos - 1] -= 1;
                    currentPos = i;
                }

                notify(a);
            }
            // This condition rearranges the array when it is required only.
            if (i == end && start < end) {
                for (int j = start; j < a.length; j++, currentPos++) {
                    if (j < a.length && currentPos <= a.length) {
                        a[j - 1 + 1] += 1;
                        a[currentPos - 1] -= 1;
                    }
                }
            }
        }
    }

    private static void notify(int[] a) {
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

}
