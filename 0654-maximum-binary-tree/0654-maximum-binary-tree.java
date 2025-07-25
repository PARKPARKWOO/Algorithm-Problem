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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int idx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[idx] < nums[i]) {
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        TreeNode l = build(nums, start, idx - 1);
        TreeNode r = build(nums, idx + 1, end);
        root.left = l;
        root.right = r;
        return root;
    }
}