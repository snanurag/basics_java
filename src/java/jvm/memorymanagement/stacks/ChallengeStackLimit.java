package jvm.memorymanagement.stacks;

/**
 * Use -Xss option from -Xss1k to -Xss10m and observe that stacks calls.
 */
public class ChallengeStackLimit {

    public static void main(String[] args) {

        try {
            /**
             * Un-comment the methods and see that how much stack can store.
             * No. of method calls will show that.
             */
//             new ChallengeStackLimit().add();
//               new ChallengeStackLimit().add(0);
//            new ChallengeStackLimit().add(0, 0);

            new ChallengeStackLimit().addwith2print(0);
        } catch (Error err) {
            System.out.println(err);
        }
    }

    public void add() {
        add();
    }

    public void add(int i) {
        System.out.println(i);
        add(++i);
    }

    public void add(int i, int j) {
      //  System.out.println(i + " " + j);
        System.out.println(i);

        add(++i, j+2);
    }

    public void addwith2print(int i){
        System.out.println(i);
        System.out.println(i);
        addwith2print(++i);
    }
}
