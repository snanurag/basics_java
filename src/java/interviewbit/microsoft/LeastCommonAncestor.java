package interviewbit.microsoft;

/**
 *
 * https://www.interviewbit.com/problems/least-common-ancestor/
 *
 */


public class LeastCommonAncestor {

    public int lca(TreeNode A, int B, int C) {
        TreeNode n = traverse(A, B, C);
        if (n == null) return -1;
        else return n.val;
    }

    private TreeNode traverse(TreeNode A, int B, int C) {

        TreeNode left = null;
        TreeNode right = null;
        if (A.left != null)
            left = traverse(A.left, B, C);

        if (A.right != null)
            right = traverse(A.right, B, C);

        if (right != null && left != null || A.val == B || A.val == C) return A;
        else if (left != null) return left;
        else return right;

    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new interviewbit.microsoft.TreeNode(2);
        t.right = new interviewbit.microsoft.TreeNode(3);
        t.left.left = new interviewbit.microsoft.TreeNode(4);
        System.out.println(new LeastCommonAncestor().lca(t, 3, 3));
    }
}
