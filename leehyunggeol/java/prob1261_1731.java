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
class FindElements {
    private Set<Integer> values = new HashSet<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }

    private void dfs(TreeNode node, int value) {
        if (node == null) {
            return;
        }
        node.val = value;
        values.add(value);
        dfs(node.left, (2*node.val) + 1);
        dfs(node.right, (2*node.val) + 2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */