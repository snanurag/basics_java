package interviews.microsoft;

/**
 * 1
 * 2     3
 * 4    5    7
 * 6    8
 * <p>
 * should convert to
 * <p>
 * 1
 * 2    8
 * 4  6
 */

public class DeleteNodeWithSingleChild {

    public Node traverse(Node n) {
        if(n == null) return null;
        Node tmp = null;
        do {
            tmp = n;
            n = properChild(tmp);
        } while (tmp != n);
        n.left = traverse(n.left);
        n.right = traverse(n.right);

        return n;
    }

    private Node properChild(Node n) {
        if (n == null || n.left == null && n.right == null || n.right != null && n.left != null)
            return n;
        else if (n.left == null) return n.right;
        else return n.left;
    }

    public static void main(String[] args) {
        Node n8 = new Node(8);
        Node n7 = new Node(7, n8, null);
        Node n3 = new Node(3, null, n7);
        Node n6 = new Node(6);
        Node n5 = new Node(5, n6, null);
        Node n4 = new Node(4);
        Node n2 = new Node(2, n4, n5);
        Node n1 = new Node(1, n2, n3);

        Node f = new DeleteNodeWithSingleChild().traverse(n1);
        System.out.println(f);


    }
}
