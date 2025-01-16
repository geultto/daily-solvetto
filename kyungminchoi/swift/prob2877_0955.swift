class Solution {
    func removeElement(_ nums: inout [Int], _ val: Int) -> Int {
        var changed = 0

        var index = 0
        while index < nums.count {
            if nums[index] == val {
                nums.remove(at: index)
                nums.append(51)
                changed += 1
            } else {
                index += 1
            }
        }

        return nums.count - changed
    }
}