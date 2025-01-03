import java.util.*;

class Solution {
    private static List<List<Integer>> Graph = new ArrayList<>();
    private static boolean[][][] Visited;
    private static int[] Node;
    private static int Answer = 0;

    public int solution(int[] info, int[][] edges) {
        Node = info.clone();
        Visited = new boolean[info.length+1][info.length+1][info.length+1];
        
        for (int i = 0; i < info.length; ++i) {
            Graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            Graph.get(edge[0]).add(edge[1]);
            Graph.get(edge[1]).add(edge[0]);
        }
        
        dfs(0, 0, 0);
        
        return Answer;
    }
    
    private void dfs(int current, int sheep, int wolf) {
        if (Visited[current][sheep][wolf]) {
            return;
        }
       
        if (Node[current] == 0) {
            ++sheep;
        }
        else if (Node[current] == 1) {
            ++wolf;
        }
        
        if (wolf >= sheep) {
            return;
        }
        
        Answer = Math.max(Answer, sheep);
            
        for (int next : Graph.get(current)) {
            int backupSheep = sheep, backupWolf = wolf, backupNode = Node[current];
            Node[current] = -1;
            Visited[current][sheep][wolf] = true;
            dfs(next, sheep, wolf);
            Node[current] = backupNode;
            Visited[current][backupSheep][backupWolf] = false;
        }
    }
}