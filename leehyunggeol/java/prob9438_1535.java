import java.util.*;

class Solution {
    static int N = 0;
    static boolean[] Visited;
    static Set<String> Answer;
    
    public int numTilePossibilities(String tiles) {
        N = tiles.length();
        Visited = new boolean[N];
        Answer = new HashSet<>();

        for (int size = 1; size <= N; ++size) {
            dfs(0, size, "", tiles);
        }
        
        return (int) Answer.size();
    }

    private void dfs(int count, int size, String letter, String tiles) {
        if (count == size) {
            Answer.add(letter);
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (Visited[i]) continue;
            Visited[i] = true;
            dfs(count+1, size, letter+tiles.charAt(i), tiles);
            Visited[i] = false;
        }
    }
}