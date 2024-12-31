def solution(target):
    MAX = target + 1
    dp = [MAX] * (target) + [0]  # dp[i]: i점을 만드는 최소 다트 수
    dp2 = [0] * (target) + [0]  # dp2[i]: i점을 만드는 최소 다트 수 중 "싱글" 또는 "불"을 맞춘 횟수
    
    single_and_bull = list(range(1,21)) + [50]
    double_and_triple = {i * 2 for i in range(11, 21)} | {i * 3 for i in range(7, 21)}
        
    for i in range(target, -1, -1):
        # 싱글, 불
        for j in single_and_bull:
            if j > i:
                continue
            if dp[i - j] > dp[i] + 1:
                dp[i - j] = dp[i] + 1
                dp2[i - j] = dp2[i] + 1
            if dp[i - j] == dp[i] + 1:
                dp2[i - j] = max(dp2[i - j], dp2[i] + 1)  
        # 더블, 트리플
        for j in double_and_triple:
            if j > i:
                continue
            if dp[i - j] > dp[i] + 1:
                dp[i - j] = dp[i] + 1
                dp2[i - j] = dp2[i]
            if dp[i - j] == dp[i] + 1:
                dp2[i - j] = max(dp2[i - j], dp2[i])   
    
    answer = [dp[0], dp2[0]]
    return answer