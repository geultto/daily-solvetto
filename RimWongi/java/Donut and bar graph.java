import java.util.*;

class Solution {
    
    /** pseudo code
    - 모든 간선이 해당 노드에서 시작하고 다른 노드로 들어오는 간선이 없는 노드 찾기
    - 해당 노드에서 시작하는 간선의 갯수에서, 해당 노드로 들어오는 간선이 없는 노드의 갯수, 해당 노드에서 시작하는 간선과 해당 노드로 들어오는 간선 모두가 두 개 이상인 노드의 갯수를 뺀 값을 계산
    - 해당 노드에서 시작하는 간선이 없는 노드 갯수 찾기
    - 해당 노드에서 시작하는 간선과 해당 노드로 들어오는 간선 모두가 두 개 이상인 노드의 갯수 찾기
    - 각 노드의 '나가는 간선'의 수와 '들어오는 간선'의 수를 저장하는 맵에 조건 확인 후 결과를 answer 배열에 저장
    **/
    
    public int[] solution(int[][] edges) {
        
        int[] answer = new int[4];
        Map<Integer, Integer[]> ioMap = new HashMap<>();
        int maxNode = -1;

        // 간선 정보를 받아 그래프 생성, maxNode 갱신
        for(int[] v : edges) {
            int from = v[0];
            int to = v[1];
            ioMap.putIfAbsent(from, new Integer[]{0, 0});
            ioMap.putIfAbsent(to, new Integer[]{0, 0});
            ioMap.get(from)[0]++; // 'from' 노드의 '나가는 간선' 수 증가
            ioMap.get(to)[1]++; // 'to' 노드의 '들어오는 간선' 수 증가
            maxNode = Math.max(maxNode, Math.max(from, to)); // maxNode 갱신
        }

        // 조건 확인 후 결과 저장
        for(int node = 1; node <= maxNode; node++) {
            // 해당 노드에 대한 정보가 없으면 다음 노드로 이동
            if(!ioMap.containsKey(node)) {
                continue;
            }
            // '나가는 간선'이 2개 이상이고 '들어오는 간선'이 없음 (생성 정점)
            if(ioMap.get(node)[0] >= 2 && ioMap.get(node)[1] == 0) { 
                answer[0] = node;
            // '나가는 간선'이 없는 노드
            } else if(ioMap.get(node)[0] == 0) {
                answer[2]++;
            // '나가는 간선'과 '들어오는 간선'이 모두 2개 이상인 노드
            } else if(ioMap.get(node)[0] >= 2 && ioMap.get(node)[1] >= 2) {
                answer[3]++;
            }
        }

        // '나가는 간선'이 2개 이상인 노드에서 '나가는 간선'이 없는 노드와 '나가는 간선'과 '들어오는 간선'이 모두 2개 이상인 노드
        answer[1] = ioMap.get(answer[0])[0] - (answer[2] + answer[3]);
        return answer;
    }
}