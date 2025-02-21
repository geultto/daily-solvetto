from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class FindElements:
    def __init__(self, root: Optional[TreeNode]):
        self._tree = root
        self._initialize_tree(root, 0)

    def _initialize_tree(self, node: Optional[TreeNode], val: int):
        if node is None:
            return

        node.val = val
        self._initialize_tree(node.left, 2 * val + 1)
        self._initialize_tree(node.right, 2 * val + 2)

    def find(self, target: int) -> bool:
        return self._find(self._tree, target)

    def _find(self, node: Optional[TreeNode], target: int):
        if node is None:
            return False

        if node.val == target:
            return True

        if node.val > target:
            return False

        return self._find(node.left, target) or self._find(node.right, target)