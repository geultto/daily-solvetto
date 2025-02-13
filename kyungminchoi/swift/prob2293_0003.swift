class Solution {
    func containsNearbyDuplicate(_ nums: [Int], _ k: Int) -> Bool {
        if k == 0 { return false }

        // when k is bigger than nums.count
        if k >= nums.count {
            return Set(nums).count < nums.count
        }

        var existance = [Int: Bool]()
        var mostRecentIndex = [Int: Int]()

        for i in 0..<nums.count {
            if let exists = existance[nums[i]] {
                let nearby = mostRecentIndex[nums[i]]!
                if i - nearby <= k {
                    return true
                }
            }

            existance[nums[i]] = true
            mostRecentIndex[nums[i]] = i

        }

        return false
    }
}