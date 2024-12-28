from collections import deque

def solution(a, edges):
    # 트리 생성
    n = len(a)
    tree = [set() for _ in range(n)]
    for u, v in edges:
        tree[u].add(v)
        tree[v].add(u)
    
    # 연결된 정점이 하나인 노드(리프 노드)부터 queue에 추가
    queue = deque([])
    for i in range(n):
        if len(tree[i]) == 1:
            queue.append(i)
    
    answer = 0
    while queue:
        cur = queue.popleft()

        # 현재 노드와 연결된 유일한 부모 노드 찾기
        if tree[cur]:
            parent = next(iter(tree[cur]))
        else:
            # 더 이상 연결된 노드가 없는 경우 (마지막 노드에 도달)
            if a[cur] != 0:  # 가중치가 0이 아니면 실패
                return -1
            continue
        
        answer += abs(a[cur])
        a[parent] += a[cur]  # 부모 노드에 현재 가중치 넘김
        a[cur] = 0  # 현재 노드의 가중치를 0으로 설정
        
        # 현재 노드와 부모 노드 간의 연결 제거
        tree[cur].remove(parent)
        tree[parent].remove(cur)
        
        # 부모 노드가 리프 노드가 되면 큐에 추가
        if len(tree[parent]) == 1:
            queue.append(parent)
    
    return answer