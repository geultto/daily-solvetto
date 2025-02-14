import java.util.*;

public class Main {
    static int N = 0, M = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        boolean[] visited = new boolean[N];

        dfs(visited, 0, 0);
    }

    private static void dfs(boolean[] visited, int start, int depth) {
        if (depth == M) {
            for (int n = 0; n < N; ++n) {
                if (visited[n]) {
                    System.out.print((n+1) + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(visited, i, depth+1);
            visited[i] = false;
        }
    }
}