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
    int answer = 0;
    public int maxDepth(TreeNode root) {
        search(root, 0);
        return answer;
    }

    void search(TreeNode t, int depth) {
        if (t == null) {
            answer = Math.max(answer, depth);
            return;
        }

        search(t.left, depth + 1);
        search(t.right, depth + 1);
    } 
}