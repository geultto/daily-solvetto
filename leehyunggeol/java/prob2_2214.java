import java.util.*;

public class Main {
    private static int N = 0;
    private static int M = 0;
    private static int R1 = 0, C1 = 0, R2 = 0, C2 = 0;
    private static int[] DX = {0,1,0,-1};
    private static int[] DY = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 4; j++) {
                queries[i][j] = sc.nextInt();
            }
        }

        N = n;
        M = m;

        for (int[] query : queries) {
            rotateClockwise(arr, query);
            avg(arr, query);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }

    private static void rotateClockwise(int[][] arr, int[] query) {
        R1 = query[0]-1;
        C1 = query[1]-1;
        R2 = query[2]-1;
        C2 = query[3]-1;

        int x = R1, y = C1, temp = arr[R1][C1], direction = 0;

        while (true) {
            int nx = x + DX[direction];
            int ny = y + DY[direction];

            int swapTemp = arr[nx][ny];
            arr[nx][ny] = temp;
            temp = swapTemp;
                
            x = nx;
            y = ny;
                
            direction = turn(x, y, direction);
                
            if (x == R1 && y == C1) {
                break;
            }
        }        
    }

    private static int turn(int x, int y, int direction) {
        if (x == R1 && y == C2) {
            return 1;
        } else if (x == R2 && y == C2) {
            return 2;
        } else if (x == R2 && y == C1) {
            return 3;
        }
        return direction;
    }

    private static void avg(int[][] arr, int[] query) {
        R1 = query[0]-1;
        C1 = query[1]-1;
        R2 = query[2]-1;
        C2 = query[3]-1;

        List<Integer> avgs = new ArrayList<>();
        for (int i = R1; i <= R2; ++i) {
            for (int j = C1; j <= C2; ++j) {
                avgs.add(getAvg(arr, i, j));
            }
        }

        int index = 0;
         for (int i = R1; i <= R2; ++i) {
            for (int j = C1; j <= C2; ++j) {
                arr[i][j] = avgs.get(index++);
            }
        }
    }

    private static int getAvg(int[][] arr, int x, int y) {
        int[] nums = new int[4];
        nums[0] = isInRange(x-1, y) ? arr[x-1][y] : -1;
        nums[1] = isInRange(x+1, y) ? arr[x+1][y] : -1;
        nums[2] = isInRange(x, y-1) ? arr[x][y-1] : -1;
        nums[3] = isInRange(x, y+1) ? arr[x][y+1] : -1;

        int count = 5;
        for (int i = 0; i < 4; ++i) {
            if (nums[i] < 0) {
                --count;
                nums[i] = 0;
            }
        }

        return (arr[x][y] + nums[0] + nums[1] + nums[2] + nums[3]) / count;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}