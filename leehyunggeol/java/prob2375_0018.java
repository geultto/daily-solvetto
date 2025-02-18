import java.util.*;

class Solution {
    static int N = 0;
    static String Answer;
    static boolean[] Visited;

    public String smallestNumber(String pattern) {
        Answer = "999999999";
        N = pattern.length()+1;
        Visited = new boolean[10];

        dfs("", pattern, 0);

        return Answer;
    }

    private void dfs(String number, String pattern, int depth) {
        if (depth == N) {
            Answer = Integer.toString(Math.min(Integer.parseInt(Answer), Integer.parseInt(number)));
            return;
        }

        for (int i = 1; i <= N; ++i) {
            if (number.length() == 0) {
                Visited[i] = true;
                dfs(number+i, pattern, depth+1);
                Visited[i] = false;
            } else {
                int prev = number.charAt(depth-1)-'0';
                char p = pattern.charAt(depth-1);

                if (Visited[i]) continue;  
                if (p == 'I' && i > prev) {
                    Visited[i] = true;
                    dfs(number+i, pattern, depth+1);
                    Visited[i] = false;
                } else if (p == 'D' && i < prev) {
                    Visited[i] = true;
                    dfs(number+i, pattern, depth+1);
                    Visited[i] = false;
                }
            }
        }
    }
}