package algos;

/**
 * https://leetcode.com/problems/binary-tree-cameras/
 */

import java.util.HashSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class BinaryTreeCameras {
    HashSet<TreeNode> container = new HashSet<>();
    int ans = 0;
    public int minCameraCover(TreeNode root) {
        dfs(root, null);
        return ans;
    }

    private void dfs(TreeNode n, TreeNode p){
        if (n.left != null){
            dfs(n.left, n);
        }
        if (n.right != null){
            dfs(n.right, n);
        }

        if(p == null && !container.contains(n)
                || !container.contains(n.left)
                || !container.contains(n.right)){
            container.add(n.left);
            container.add(n.right);
            container.add(n);
            container.add(p);
            ans++;
        }
    }

    public static void main(String[] args) {

    }
}