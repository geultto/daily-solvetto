/// LeetCode No.3152 Special Array II
/// https://leetcode.com/problems/special-array-ii/description/

class Solution {
    func isArraySpecial(_ nums: [Int], _ queries: [[Int]]) -> [Bool] {
        var available = Array(repeating: false, count: nums.count - 1)

        for i in 0..<nums.count - 1 {
            if nums[i] % 2 != nums[i+1] % 2 {
                available[i] = true
            }
        }

        var result = [Bool]()
        for query in queries {
            let availability = available[query[0]..<query[1]].reduce(true) { $0 && $1 }
            result.append(availability)
        }

        return result
    }
}
