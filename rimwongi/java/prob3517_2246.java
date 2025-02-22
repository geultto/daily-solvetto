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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        
        int i = 0;
        while (i < traversal.length()) {
            int depth = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }
            
            int val = 0;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            
            TreeNode node = new TreeNode(val);
            
            if (stack.isEmpty()) {
                stack.push(node);
                continue;
            }
            
            while (stack.size() > depth) {
                stack.pop();
            }
            
            // Add as left or right child
            TreeNode parent = stack.peek();
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            
            stack.push(node);
        }
        
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }
}