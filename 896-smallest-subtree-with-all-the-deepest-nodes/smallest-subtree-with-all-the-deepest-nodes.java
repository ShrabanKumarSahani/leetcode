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
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).getKey();
    }

    private Pair<TreeNode, Integer> dfs(TreeNode root) {
        // Base case: null node has depth 0
        if (root == null) {
            return new Pair<>(null, 0);
        }
      
        // Recursively process left and right subtrees
        Pair<TreeNode, Integer> leftResult = dfs(root.left);
        Pair<TreeNode, Integer> rightResult = dfs(root.right);
      
        // Extract depths from the results
        int leftDepth = leftResult.getValue();
        int rightDepth = rightResult.getValue();
      
        // If left subtree is deeper, all deepest nodes are in left subtree
        if (leftDepth > rightDepth) {
            return new Pair<>(leftResult.getKey(), leftDepth + 1);
        }
      
        // If right subtree is deeper, all deepest nodes are in right subtree
        if (leftDepth < rightDepth) {
            return new Pair<>(rightResult.getKey(), rightDepth + 1);
        }
      
        // If both subtrees have same depth, current node is the LCA of all deepest nodes
        return new Pair<>(root, leftDepth + 1);
    }
}