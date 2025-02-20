class Solution {
    func findDifferentBinaryString(_ nums: [String]) -> String {
        var results: [String] = []

        traverse(["0"], nums[0].count, &results)
        traverse(["1"], nums[0].count, &results)

        return results.filter { !nums.contains($0) }[0]
    }

    func traverse(_ current: [String], _ digits: Int, _ results: inout [String]) {
        guard current.count < digits else {
            results.append(current.joined())
            return
        }

        traverse(current + ["0"], digits, &results)
        traverse(current + ["1"], digits, &results)
    }
}