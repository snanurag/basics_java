package interviews.greyorange;

/**
 * Give the sum of all the odd divisors of a number. Number could be from 1 to 10^9.
 * e.g. 5 is divisible by 1 and 5. So sum is 1+5 = 6
 *
 */
public class SumOfOddDivisors {

    public static void main(String[] args) {
        int number = 2000000001;

        long start = System.currentTimeMillis();
        long tmp = 0;
        int sqRt = (int)Math.sqrt(number);
        for(int i=1; i < sqRt; i +=2){
            if(number%i == 0){
                tmp += i;
                tmp += number/i;
            }
        }

        System.out.println(System.currentTimeMillis() - start);
        System.out.println(tmp);
    }


}
