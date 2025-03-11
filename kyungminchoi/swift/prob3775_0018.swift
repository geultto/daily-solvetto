class Solution {
    func numberOfSubstrings(_ s: String) -> Int {
        let s = s.map { String($0) }
        let n = s.count
        var result = 0

        var left = 0
        var right = 0
        var frequency = Array(repeating: 0, count: 3)

        let idx = ["a": 0, "b": 1, "c": 2]

        while right < n {
            frequency[idx[s[right]]!] += 1

            while frequency.filter { $0 > 0 }.count == 3 {
                result += n - right

                frequency[idx[s[left]]!] -= 1
                left += 1
            }

            right += 1
        }

        return result
    }
}