/**
 Tree Traversal using DFS
 */

import java.util.*;

class FindElements {

    Set<Integer> treeNodes;

    public FindElements(TreeNode root) {
        treeNodes = new HashSet<>();
        dfs(root, 0); // root node의 값: 1이 아닌 0
    }

    public boolean find(int target) {
        return treeNodes.contains(target);
    }

    private void dfs(TreeNode currentNode, int currentValue) {
        if (currentNode == null) {
            return;
        }

        treeNodes.add(currentValue);
        dfs(currentNode.left, currentValue * 2 + 1);
        dfs(currentNode.right, currentValue * 2 + 2);
    }
}