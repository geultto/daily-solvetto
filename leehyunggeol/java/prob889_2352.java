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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int numOfNodes = preorder.length;
        return construct(0, numOfNodes - 1, 0, preorder, postorder);
    }

    private TreeNode construct(int preStart, int preEnd, int postStart, int[] preorder, int[] postorder) {
        if (preStart > preEnd) return null;

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int leftRoot = preorder[preStart + 1];

        int numOfNodesInLeft = 1;
        while (postorder[postStart + numOfNodesInLeft - 1] != leftRoot) {
            numOfNodesInLeft++;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        root.left = construct(preStart + 1, preStart + numOfNodesInLeft, postStart, preorder, postorder);
        root.right = construct(preStart + numOfNodesInLeft + 1, preEnd, postStart + numOfNodesInLeft, preorder, postorder);

        return root;
    }
}