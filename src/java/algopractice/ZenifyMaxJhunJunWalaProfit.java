package algopractice;

public class ZenifyMaxJhunJunWalaProfit {


    static int maxProfit(int[] prices) {

        int min = prices[0];
        int max = prices[0];
        int minIndex = 0;
        int maxIndex = 0;
        int sum = -1;

        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                minIndex = i;
            }

            if (max < prices[i] || maxIndex < minIndex) {
                max = prices[i];
                maxIndex = i;
            }

            if (maxIndex > minIndex) {
                if (max - min > sum)
                    sum = max - min;
            }

        }

        return sum;

    }

}
