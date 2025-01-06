import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 100_000_000;
        int[][] graph = new int[n+1][n+1];
        
        for (int i = 1; i <= n; ++i) {
            Arrays.fill(graph[i], 100_000_000);
        }
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }
        
        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int cost = fare[2];
            graph[c][d] = cost;
            graph[d][c] = cost;
        }
        
        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        
        for (int i = 1; i <= n; ++i) {
            answer = Math.min(answer, graph[s][i]+graph[i][a]+graph[i][b]);
        }
        
        return answer;
    }
}