import java.util.*;

public class Main {
    static int N = 0, M = 0, K = 0, Answer = 0;

    static int[] Turns;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();  
        M = scanner.nextInt();  
        K = scanner.nextInt();  

        Turns = new int[N];
        for (int i = 0; i < N; i++) {
            Turns[i] = scanner.nextInt();
        }

        dfs(new int[K], 0);

        System.out.println(Answer);
    }

    private static void dfs(int[] players, int size) {
        if (size == N) {
            Answer = Math.max(Answer, calculateScore(players));
            return;
        }

        for (int i = 0; i < K; ++i) {
            players[i] += Turns[size];
            dfs(players, size+1);
            players[i] -= Turns[size];
        }
    }

    private static int calculateScore(int[] players) {
        int result = 0;

        for (int p : players) {
            if (p >= M-1) {
                ++result;
            }
        }

        return result;
    }
}