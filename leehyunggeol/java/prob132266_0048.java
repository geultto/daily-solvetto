import java.util.*;

class Solution {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] dist = bfs(n, destination);
        
        for (int i = 0; i < sources.length; ++i) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
    
    private int[] bfs(int n, int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n+1];
        
        Arrays.fill(dist, -1);
        
        dist[start] = 0;
        q.add(start);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i = 0; i < graph.get(cur).size(); ++i){
                int next = graph.get(cur).get(i);
                
                if(dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
        
        return dist;
    }
}