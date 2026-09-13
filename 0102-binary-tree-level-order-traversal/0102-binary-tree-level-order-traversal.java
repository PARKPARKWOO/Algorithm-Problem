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
    List<List<Integer>> answer;
    public List<List<Integer>> levelOrder(TreeNode root) {
        answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<NodeDepth> q = new LinkedList<>();
        q.add(new NodeDepth(root, 0));
        while (!q.isEmpty()) {
            NodeDepth poll = q.poll();
            TreeNode node = poll.node;
            if (poll.depth == answer.size()) {
                answer.add(new ArrayList<>());
            }
            List<Integer> list = answer.get(poll.depth);
            list.add(poll.node.val);
            if (node.left != null) {
                q.add(new NodeDepth(node.left, poll.depth + 1));
            }

            if (node.right != null) {
                q.add(new NodeDepth(node.right, poll.depth + 1));
            }
        }
        return answer;
    }
}
class NodeDepth {
    TreeNode node;
    int depth;
    public NodeDepth(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}