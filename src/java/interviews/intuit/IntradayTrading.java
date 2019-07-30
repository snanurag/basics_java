package interviews.intuit;

public class IntradayTrading {

    /**
     * Customer1 sell INFY below 1045 and above 1055
     * Customer1 buy INFY above 1047 and below 1052
     *
     * Customer2 sell INFY below 1043 and above 1056
     * Customer2 buy INFY above 1046 and below 1053
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Table
         * INFY         cust2 sell
         * INFY 1043    cust1 sell
         * INFY 1045
         * INFY 1046    cust2 buy
         * INFY 1047    cust1 buy, cust2 buy
         * INFY 1052    cust2 buy
         * INFY 1053
         * INFY 1055    cust1 sell
         * INFY 1056    cust2 sell
         */
    }
}
