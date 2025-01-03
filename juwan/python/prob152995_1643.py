def solution(scores):
    rank_sum = []
    원호_a = scores[0][0]
    원호_b = scores[0][1]
                     
    # max_b[a] : 근무 태도 점수가 a 이상인 인사고과 중, 가장 높은 동료 평가 점수
    max_b = [-1 for _ in range(100002)]    
    for a, b in scores:
        max_b[a] = max(max_b[a], b)
    
    cur_max_b = -1
    for i in range(100001, -1, -1):
        max_b[i] = max(cur_max_b, max_b[i])
        cur_max_b = max(cur_max_b, max_b[i])
    
    
    if max_b[원호_a + 1] > 원호_b:
        return -1 
    for a, b in scores:
        # max_b[a + 1] > -1 : a 보다 높은 근무 태도 점수 존재
        # max_b[a + 1] > b  : a 보다 근무 태도 점수 높고, 동료 평가 점수도 높은 사람 존재
        if max_b[a + 1] <= b:
            rank_sum.append(a + b)
    
    answer = 0
    rank_sum.sort(reverse = True)
    for i in range(len(rank_sum)):
        if rank_sum[i] == 원호_a + 원호_b:
            answer = i + 1
            break
    
    return answer