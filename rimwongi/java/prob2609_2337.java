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
    private Map<Integer, Integer> postIndexMap;
    private int preIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return construct(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int left, int right) {
        if (left > right) 
            return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (left == right) 
            return root; 

        int leftRootVal = preorder[preIndex];
        int postLeftSubtreeEnd = postIndexMap.get(leftRootVal);

        root.left = construct(preorder, postorder, left, postLeftSubtreeEnd);
        root.right = construct(preorder, postorder, postLeftSubtreeEnd + 1, right - 1);
        return root;
    }
}