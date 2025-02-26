import java.util.*;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    
    public static int N;
    public static int[][] Matrix;
    // dp[x][y][m]: (x,y)에 도달했을 때, 경로상의 최소값이 m인 상태에서 기록된 최소의 currMax 값을 저장
    // 미방문 상태는 -1로 초기화
    public static int[][][] dp;

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Matrix = new int[N][N];
        dp = new int[N][N][101];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                Matrix[i][j] = sc.nextInt();
            }
        }
        
        initializeDP();

        // (0,0)에서 시작하면, 초기 상태로 최소값과 최대값 모두 num[0][0]으로 시작
        System.out.print(dfs(0, 0, Matrix[0][0], Matrix[0][0]));
    }
    
    public static void initializeDP() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }
    
    /**
     * DFS로 (0,0)에서 (n-1, n-1)까지 경로를 탐색합니다.
     * @param x 현재 행 좌표
     * @param y 현재 열 좌표
     * @param currMin 현재까지 경로의 최소값
     * @param currMax 현재까지 경로의 최대값
     * @return 도착했을 때 (currMax - currMin), 즉 경로의 최댓값과 최솟값의 차이
     */
    public static int dfs(int x, int y, int currMin, int currMax) {
        if (x == N - 1 && y == N - 1) {
            // 도착지에서는 이미 최소, 최대값이 결정되어 있으므로 바로 차이를 반환
            return currMax - currMin;
        }
        // 같은 (x,y)에서 currMin 상태로 이미 더 좋은(currMax가 낮은) 값으로 방문한 적이 있다면 가지치기
        if (dp[x][y][currMin] != -1 && dp[x][y][currMin] <= currMax) {
            return INT_MAX;
        }
        dp[x][y][currMin] = currMax;
        
        int ans = INT_MAX;
        // 오른쪽과 아래로 이동 (dx,dy 사용)
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        for (int d = 0; d < 2; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (isInRange(nx, ny)) {
                int newMin = Math.min(currMin, Matrix[nx][ny]);
                int newMax = Math.max(currMax, Matrix[nx][ny]);
                ans = Math.min(ans, dfs(nx, ny, newMin, newMax));
            }
        }

        return ans;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}