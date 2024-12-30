import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> Graph = new ArrayList<ArrayList<Integer>>();
    private static int Answer = 0;
    
    public int solution(int n, int[][] lighthouse) {
        for (int i = 0; i <= n; ++i) {
            Graph.add(new ArrayList<>());
        }
        
        for (int[] light : lighthouse) {
            int a = light[0];
            int b = light[1];
            Graph.get(a).add(b);
            Graph.get(b).add(a);
        }
        
        dfs(1, 0);
        
        return Answer;
    }
    
    private int dfs(int current, int previous) {
        if (Graph.get(current).size() == 1 && Graph.get(current).get(0) == previous) {
            return 1;
        }
        
        int isLightOn = 0;
        
        for (int next : Graph.get(current)) {
            if (next == previous) {
                continue;
            }
            isLightOn += dfs(next, current);
        }
        
        if (isLightOn == 0) {
            return 1;
        } else {
            ++Answer;
        }
        
        return 0;
    }
}