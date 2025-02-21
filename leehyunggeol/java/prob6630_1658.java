import java.util.*;

public class Main {
    static final int UNUSED = -1;
    static int N = 0;
    static int[][] Matrix, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Matrix = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                Matrix[i][j] = sc.nextInt();
                dp[i][j] = UNUSED;
            }
        }

        System.out.println(getMaxOfMin(0,0));
    }

    private static int getMaxOfMin(int x, int y) {
        if (dp[x][y] != UNUSED) {
            return dp[x][y];
        }
        if (x == N-1 && y == N-1) {
            return dp[x][y] = Matrix[x][y];
        }

        int[] dx = {0,1};
        int[] dy = {1,0};
        int maxValue = -1;

        for (int d = 0; d < 2; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!isInRange(nx, ny)) continue;
            maxValue = Math.max(maxValue, Math.min(Matrix[x][y], getMaxOfMin(nx, ny)));
        }

        dp[x][y] = maxValue;

        return maxValue;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}