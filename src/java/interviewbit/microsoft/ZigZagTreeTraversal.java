package interviewbit.microsoft;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTreeTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        Stack<TreeNode> s = new Stack<>();
        s.push(A);
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        addToArrayList(l, s, 0);
        return l;
    }

    private void addToArrayList(ArrayList<ArrayList<Integer>> l, Stack<TreeNode> s, int count) {
        Stack<TreeNode> tmpS = new Stack<>();
        ArrayList<Integer> inner = new ArrayList<>();
        while (!s.empty()) {
            TreeNode a = s.pop();
            inner.add(a.val);
            if (count % 2 == 0) {
                tmpS.push(a.left);
                tmpS.push(a.right);
            } else {
                tmpS.push(a.right);
                tmpS.push(a.left);
            }
        }
        l.add(inner);
        addToArrayList(l, tmpS, count++);
    }

    public static void main(String[] args) {
    }
}


//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

