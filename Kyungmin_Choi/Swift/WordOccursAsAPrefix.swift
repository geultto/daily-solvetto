/// LeetCode No.1455 Check If a Word Occurs As a Prefix of Any Word in a Sentence
/// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description/
class Solution {
    func isPrefixOfWord(_ sentence: String, _ searchWord: String) -> Int {
        let words = sentence.components(separatedBy: " ")
        for (index, word) in words.enumerated() {
            if word.hasPrefix(searchWord) {
                return index + 1
            }
        }

        return -1
    }
}
