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
    private TreeNode root;
    public TreeNode bstFromPreorder(int[] preorder) {
        root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    private void insert(TreeNode parent, int value) {
        int pval = parent.val;
        if (pval > value) {
            if (parent.left == null) {
                parent.left = new TreeNode(value);
            } else {
                insert(parent.left, value);
            }
        } else {
            if (parent.right == null ) {
                parent.right = new TreeNode(value);
            } else {
                insert(parent.right, value);
            }
        }
    }
}