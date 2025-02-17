import java.util.*;

public class Main {
    static int N = 0, Answer = Integer.MAX_VALUE;
    static int[] DX = {-1,1,0,0};
    static int[] DY = {0,0,-1,1};  
    static int[][][][] dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        scanner.nextLine(); 

        char[][] arr = new char[N][N];

        dist = new int[N][N][10][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 10; k++) {
                    Arrays.fill(dist[i][j][k], Integer.MAX_VALUE);
                }
            }
        }

        int sx = -1, sy = -1, ex = -1, ey = -1, count = 0;

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            arr[i] = line.toCharArray();
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (arr[i][j] == 'E') {
                    ex = i;
                    ey = j;
                } else if (Character.isDigit(arr[i][j])) {
                    ++count;
                }
            }
        }
        
        if (count < 3) {
            Answer = -1;
            System.out.println(Answer);
            return;
        }

        dfs(arr, sx, sy, ex, ey, 0, 0, 0);   

        System.out.println(Answer);
    }

    private static void dfs(char[][] arr, int x, int y, int ex, int ey, int curValue, int step, int count) {
        if (step >= dist[x][y][curValue][count]) {
            return;
        }
        dist[x][y][curValue][count] = step;

        if (isEnd(x,y,ex,ey) && count == 3) {
            Answer = Math.min(Answer, step);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + DX[d];
            int ny = y + DY[d];
            if (!isInRange(nx, ny)) continue;

            int nextValue = curValue;
            int nextCount = count;
            
            if (Character.isDigit(arr[nx][ny])) {
                int digit = arr[nx][ny] - '0';
                if (digit > curValue) {
                    nextValue = digit;
                    nextCount = count + 1;
                }
            }
            if (nextCount <= 3) {
                dfs(arr, nx, ny, ex, ey, nextValue, step + 1, nextCount);
            }
        }
    }

    private static boolean isEnd(int x, int y, int ex, int ey) {
        return x == ex && y == ey;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}