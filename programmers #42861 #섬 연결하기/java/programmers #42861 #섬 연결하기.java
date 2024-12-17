import java.util.*;

class Solution {
    private static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2]-b[2];
            }
        });
        
        for (int[] info : costs) {
            int a = info[0];
            int b = info[1];
            int cost = info[2];
            
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    private int findParent(int x) {
        if (x != parent[x]) {
            return parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }
    
    private void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}