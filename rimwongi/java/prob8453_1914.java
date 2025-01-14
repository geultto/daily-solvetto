import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        // 방문한 칸
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        
        // bfs 탐색을 마치고 맨 하단 오른쪽의 값이 최단 숫자
        answer = visited[maps.length-1][maps[0].length-1];
        
        // 탐색을 마치고 answer가 0이라면 도착할 수 없는 경우
        if (answer == 0){
           answer = -1; 
        }
        
        return answer;
    }
    
    void bfs(int[][] maps, int[][] visited) {
        
        // 좌표
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 첫 스타트는 방문으로 처리하고 시작
        visited[0][0] = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        while(!queue.isEmpty()) {
            
            int[] curr = queue.remove();
            int currx = curr[0];
            int curry = curr[1];
            
            for(int i=0; i<dx.length; i++) {
                int nx = currx + dx[i];
                int ny = curry + dy[i];
                
                // 가려고 하는 방향이 막혀있는지 유무를 확인
                if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1) {
                    continue;
                }
                
                // 지나갈 수 있다면, 방문처리를 하고 queue에 해당 좌표를 추가
                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[currx][curry] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}