# site: LeetCode
# link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-interview-150

digits_to_letters = {
    "2" : ['a', 'b', 'c'],
    "3": ['d', 'e', 'f'],
    "4": ['g', 'h', 'i'],
    "5": ['j', 'k', 'l'],
    "6": ['m', 'n', 'o'],
    "7": ['p', 'q', 'r', 's'],
    "8": ['t', 'u', 'v'],
    "9": ['w', 'x', 'y', 'z']
}

from itertools import combinations

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        answer = []
        n = len(digits)
        # 예외 처리 
        if n == 0:
            return answer
        
        def backtracking(curr, index):
            if len(curr) == n:
                answer.append(curr) # digits 완성함 
                return
            
            # 현재 확인중인 숫자 
            digit = digits[index]
            for letter in digits_to_letters[digit]:
                backtracking(curr + letter, index+1)
        
        backtracking("", 0)
        
        return answer