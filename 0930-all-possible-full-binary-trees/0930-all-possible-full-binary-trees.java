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
    private Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 1) {
            return Collections.singletonList(new TreeNode(0));
        }   
        List<TreeNode> get = map.getOrDefault(n, null);
        if (get != null) return get;
        List<TreeNode> answer = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(n - i - 1);
            
            for (TreeNode r: rightNodes) {
                for (TreeNode l: leftNodes) {
                    TreeNode root = new TreeNode(0, l, r);
                    answer.add(root);
                }
            }
        }
        map.put(n, answer);
        return answer;
    }
}