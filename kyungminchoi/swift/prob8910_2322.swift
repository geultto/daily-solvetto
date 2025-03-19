class Solution {
    func minOperations(_ nums: [Int]) -> Int {
        var nums = nums
        var result = 0

        for i in 0..<nums.count - 2 {
            if nums[i] == 0 {
                nums[i] = 1

                nums[i+1] = nums[i+1] == 0 ? 1 : 0
                nums[i+2] = nums[i+2] == 0 ? 1 : 0
                
                result += 1
            }
        }

        switch nums.contains(0) {
        case true:
            return -1
        case false:
            return result
        }
    }
}