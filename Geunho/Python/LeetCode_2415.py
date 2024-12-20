# Definition for a binary tree node.
import collections
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        reversed_tree = collections.defaultdict(collections.deque)
        queue = collections.deque([(root, 0)])
        while queue:
            node, level = queue.popleft()

            if node is None:
                continue

            if level % 2 == 0:
                reversed_tree[level].append(TreeNode(node.val))
            else:
                reversed_tree[level].appendleft(TreeNode(node.val))

            queue.append((node.left, level + 1))
            queue.append((node.right, level + 1))

        max_level = max(reversed_tree.keys())
        for level in range(max_level - 1, -1, -1):
            for node in reversed_tree[level]:
                node.left = reversed_tree[level + 1].popleft()
                node.right = reversed_tree[level + 1].popleft()

        return reversed_tree[0][0]


# tree = TreeNode(
#     2,
#     TreeNode(3, TreeNode(8), TreeNode(13)),
#     TreeNode(5, TreeNode(21), TreeNode(34)),
# )
# tree = TreeNode(
#     7,
#     TreeNode(13),
#     TreeNode(11),
# )
tree = TreeNode(
    0,
    TreeNode(
        1, TreeNode(0, TreeNode(1), TreeNode(1)), TreeNode(0, TreeNode(1), TreeNode(1))
    ),
    TreeNode(
        2, TreeNode(0, TreeNode(2), TreeNode(2)), TreeNode(0, TreeNode(2), TreeNode(2))
    ),
)
Solution().reverseOddLevels(tree)
