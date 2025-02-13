import java.util.*;

public class Main {
    static int N = 0, Answer = 0;
    static int[] DX = {-1,-1,0,1,1,1,0,-1};
    static int[] DY = {0,1,1,1,0,-1,-1,-1};
    static int[][] Arr, ArrDir;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        
        Arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arr[i][j] = scanner.nextInt();
            }
        }
        
        ArrDir = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ArrDir[i][j] = scanner.nextInt();
            }
        }
        
        int x = scanner.nextInt()-1;
        int y = scanner.nextInt()-1;

        dfs(x, y, 0);

        System.out.println(Answer);
    }

    private static void dfs(int x, int y, int move) {
        if (cannotMove(x, y)) {
            Answer = Math.max(Answer, move);
            return;
        }

        for (int i = 1; i < N; ++i) {
            int nx = x + (DX[ArrDir[x][y]-1] * i);
            int ny = y + (DY[ArrDir[x][y]-1] * i);

            if (isInRange(nx, ny) && Arr[nx][ny] > Arr[x][y]) {
                dfs(nx, ny, move+1);
            }
        }
    }

    private static boolean cannotMove(int x, int y) {
        for (int i = 1; i < N; ++i) {
            int nx = x + (DX[ArrDir[x][y]-1] * i);
            int ny = y + (DY[ArrDir[x][y]-1] * i);

            if (isInRange(nx, ny) && Arr[nx][ny] > Arr[x][y]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}