/// LeetCode No.2109 Adding Spaces to a String
/// https://leetcode.com/problems/adding-spaces-to-a-string/description/
class Solution {
    func addSpaces(_ s: String, _ spaces: [Int]) -> String {
        var letterIndex = 0
        var spaceIndex = 0
        let letters = Array(s)

        var result = [Character]()

        while letterIndex < letters.count {
            if spaceIndex < spaces.count {
                if spaces[spaceIndex] == letterIndex {
                    result.append(" ")
                    spaceIndex += 1
                }
            }

            result.append(letters[letterIndex])
            letterIndex += 1
        }

        return String(result)
    }
}
