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
    private int n;
    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        int[] index = {0};      // using array for pass by reference option
        return solve (traversal, index, 0);
    }

    private TreeNode solve(String traversal, int[] index, int depth) {
        if(index[0] >= n) {
            return null;
        }

        int j = index[0];
        while(j < n && traversal.charAt(j) == '-') {
            j++;
        }

        int dash = j - index[0];
        if(depth != dash) {
            return null;
        }
        index[0] += dash;

        int value = 0;
        while(index[0] < n && Character.isDigit(traversal.charAt(index[0]))) {
            value = (value*10) + (traversal.charAt(index[0]) - '0');
            index[0]++;
        }

        TreeNode root = new TreeNode(value);
        root.left = solve(traversal, index, depth + 1);
        root.right = solve(traversal, index, depth + 1);

        return root;
    }
}
/**
TC = O(n)
SC = O(n) 
*/