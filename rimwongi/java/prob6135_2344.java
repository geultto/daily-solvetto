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
    private Set<Integer> values;
    
    public FindElements(TreeNode root) {
        values = new HashSet<>();
        root.val = 0;
        recoverTree(root);
    }
    
    private void recoverTree(TreeNode node) {
        if (node == null) return;
        
        values.add(node.val);
        
        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            recoverTree(node.left);
        }
        
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            recoverTree(node.right);
        }
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */