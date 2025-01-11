# https://leetcode.com/problems/daily-temperatures/

from types import List
# 시도 1 : TimeLimit 
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        answer = []
        for i in range(n-1):
            now = temperatures[i]
            count = 0
            flag = False 
            for j in range(i+1, n):
                count += 1
                if j == (n-1) and not flag:
                    answer.append(0)
                if temperatures[j] > now:
                    answer.append(count)
                    flag = True 
                    break
                
        answer.append(0)
        if len(answer) != n:
            answer.append(0)
        return answer 
    
# 시도 2 : Stack 자료구조 활용 
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        answer = []
        stack = []
        
        for i in range(n):
            print(temperatures[i])
            if not stack:
                stack.append(temperatures[i])
                continue
            
            if stack[0] < temperatures[i]:
                answer.append(len(stack))
                stack.pop(0)

                while stack:
                    print("head of stack:", stack[0])
                    print("length of stack:", len(stack))
                    answer.append(len(stack)-1)
                    stack.pop(0)
                 
                stack.append(temperatures[i])
            else:
                stack.append(temperatures[i])

        
        # stack 길이 수만큼 answer 에 0 을 추가한다. 
        while stack:
            stack.pop()
            answer.append(0)

        return answer 

# 3차 시도 (성공)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        answer = [0 for _ in range(n)]
        stack = [0]
        
        for i, tem in enumerate(temperatures):
            print(tem)
            
            while stack and temperatures[stack[-1]] < tem:
                top = stack.pop() 
                answer[top] = (i - top)

            stack.append(i) # index 를 append 
        return answer 