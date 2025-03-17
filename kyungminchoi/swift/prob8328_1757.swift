class Solution {
    func divideArray(_ nums: [Int]) -> Bool {
        var occurences = [Int: Int]()

        for num in nums {
            if let occurence = occurences[num] {
                occurences[num] = occurence + 1
            } else {
                occurences[num] = 1
            }
        }

        for e in occurences.values {
            if e % 2 != 0 {
                return false
            }
        }

        return true
    }
}