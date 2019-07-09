package interviews.visa;

/**
 * Calculate the vertical sum of a tree.
 */
public class VerticalSum2 {

    public int move(Node n, int away){
        if(n == null)
            return 0;
        int s = 0;
        if(away == 0){
            s+=n.val;
        }
        s += move(n.left, away-1);
        s += move(n.right, away +1);

        return s;
    }

    public int verticalSum(Node n){
        return move(n, 0);
    }

    public static void main(String[] args) {
        VerticalSum2 t = new VerticalSum2();
        System.out.println(t.verticalSum(exampleOne()) == 36);
        System.out.println(t.verticalSum(exampleTwo()) == 53);

    }

    private static Node exampleOne(){
        //             1
        //        2          3
        //    4       5    7      6
        //        8     9
        //     10  11 12  13
        // sum = 1 +5 +7+ 11+12 = 36

        Node n13 = new Node(13);
        Node n12 = new Node(12);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n9 = new Node(9,n12,n13);
        Node n8 = new Node(8,n10,n11);
        Node n7 = new Node(7);
        Node n6 = new Node(6);
        Node n5 = new Node(5,n8,n9);
        Node n4 = new Node(4);
        Node n3 = new Node(3,n7,n6);
        Node n2 = new Node(2, n4 ,n5);
        Node n1 = new Node(1, n2, n3);
        return n1;
    }

    private static Node exampleTwo(){
        //             1
        //        2          3
        //    4       5    7      6
        //        8     9
        //     10  11 12  13
        //   14
        //     15
        //       16
        //         17
        // sum = 1 +5 +7+ 11+12 +17 = 53

        Node n17 = new Node(17);
        Node n16 = new Node(16, null,n17);
        Node n15 = new Node(15, null,n16);
        Node n14 = new Node(14, null,n15);
        Node n13 = new Node(13);
        Node n12 = new Node(12);
        Node n11 = new Node(11);
        Node n10 = new Node(10, n14, null);
        Node n9 = new Node(9,n12,n13);
        Node n8 = new Node(8,n10,n11);
        Node n7 = new Node(7);
        Node n6 = new Node(6);
        Node n5 = new Node(5,n8,n9);
        Node n4 = new Node(4);
        Node n3 = new Node(3,n7,n6);
        Node n2 = new Node(2, n4 ,n5);
        Node n1 = new Node(1, n2, n3);
        return n1;
    }
}

class Node {
    Node(int val){
        this.val = val;

    }
    Node( int val, Node left, Node right){
        this.left = left;
        this.right = right;
        this.val = val;
    }
    Node left;
    Node right;
    int val;
}

