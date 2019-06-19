package interviews.microsoft;

public class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "{ v:" + val + (left != null ? " l:" + left : "") + (right != null ? " r:" + right : "") + " }";
    }
}

