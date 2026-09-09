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
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        recur(root, 0);
        return answer;
    }

    void recur(TreeNode node, int depth) {
        if (node == null) return;
        if (answer.size() == depth) {
            answer.add(new ArrayList<>());
        }
        answer.get(depth).add(node.val);
        
        recur(node.left, depth + 1);
        recur(node.right, depth + 1);
    }
}