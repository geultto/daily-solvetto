/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init() { self.val = 0; self.next = nil; }
 *     public init(_ val: Int) { self.val = val; self.next = nil; }
 *     public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
 * }
 */
class Solution {
    func deleteDuplicates(_ head: ListNode?) -> ListNode? {
        guard let head else { return nil }

        var list: ListNode? = head
        var previousNode = head
        var previousValue = previousNode.val
        var result = head

        guard list?.next != nil else {
            return list
        }

        list = list?.next!

        while let currentList = list {
            if currentList.val == previousValue {
                previousNode.next = currentList.next
            } else {
                previousNode = currentList
                previousValue = currentList.val
            }

            list = currentList.next
        }

        return result
    }
}