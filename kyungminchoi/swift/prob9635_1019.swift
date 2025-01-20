/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
 */
class Solution {
    func hasPathSum(_ root: TreeNode?, _ targetSum: Int) -> Bool {
        // DFS, 재귀로 풀기
        // 노드가 nil이면 false로 반환
        guard let root else { return false }

        // 지금 노드가 leaf고, 값이 targetSum과 같다면 true 반환
        if root.left == nil, root.right == nil, root.val == targetSum {
            return true
        }

        // 좌 우 노드에 대해 재귀적으로 수행
        return hasPathSum(root.left, targetSum - root.val) 
        || hasPathSum(root.right, targetSum - root.val)
    }
}