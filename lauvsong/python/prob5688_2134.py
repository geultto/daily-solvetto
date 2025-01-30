from collections import defaultdict, deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = defaultdict(list)
        indegreeNum = defaultdict(int)

        for nextCourse, preCourse in prerequisites:
            indegree[preCourse].append(nextCourse)
            indegreeNum[nextCourse] += 1

        # 진입 차수가 0인 것
        q = deque([course for course in indegree.keys() if course not in indegreeNum.keys()])

        while q:
            preCourse = q.popleft()

            for nextCourse in indegree.pop(preCourse, []):
                indegreeNum[nextCourse] -= 1
                if indegreeNum[nextCourse] == 0:
                    q.append(nextCourse)
            
        return len(indegree) == 0

"""
# 문제
사이클이 탐지되면 False, 아니면 True

Topological Sort (위상정렬)
- 진입차수가 0인 것을 고르고, 연결된 노드의 진입차수를 1씩 제거하며 BFS
- 사이클인 경우 진입차수가 0이 되는게 불가능 -> BFS 후 진입차수가 0이 되지 않은 노드가 있으면 사이클 True

indegree = {key: prerequisite, value: course list}
indegreeNum = {key: courseNumber, value: 진입차수}

# Complexity
n = 노드 수
p = 간선 수
시간복잡도: O(n + p)
공간복잡도: O(n + p)

"""