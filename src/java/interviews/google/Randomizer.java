package interviews.google;

/**
 * Generate randomizer with the colored balls in a basket
 *
 * Problem of weighted randomness
 * Problem statement : I need to return a random color. But red should be picked 4 times as frequent as blue and 2 times as frequent as green.
 *
 * There could be millions of colors of balls with millions of balls of each color.
 */
public class Randomizer {

    int[] store = null;
    public String randomNumber(String[] color, int[] nums){
        if(store == null){
            createStore(nums);
        }
        double rNum = Math.random() * store[store.length -1];
        return color[binarySearchIndex((int)rNum)];
    }

    private int binarySearchIndex(int num){
        if(num < store[0]) return 0;
        int lower = 0;
        int upper = store.length -1;

        while( upper - lower > 1){
            int tmp = (lower + upper) / 2;
            if(num < store[tmp]) upper = tmp;
            else lower = tmp;
        }
        return upper;
    }

    private void createStore(int[] nums){
        store = new int[nums.length];
        int count=0;
        for(int i=0; i<nums.length; i++){
            count +=nums[i];
            store[i] = count;
        }
    }

    public static void main(String[] args) {
//        while(true) System.out.println(Math.random());
        System.out.println(new Randomizer().randomNumber(new String[]{"r","g","b"}, new int[]{4,2,1}));
    }
}

