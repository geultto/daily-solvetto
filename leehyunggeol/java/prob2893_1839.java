import java.util.*;

public class Main {
    private static final int BLANK = 0, DOWN = 0, LEFT = 1, UP = 2, RIGHT = 3;

    private static int N = 0, Answer = 0;
    private static int[] DX = {1,0,-1,0};
    private static int[] DY = {0,-1,0,1};
    private static boolean[][][] Visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] copiedArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                copiedArr[i][j] = arr[i][j];
            }
        }

        sc.close();

        N = n;

        Visited = new boolean[N][N][4];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                int bombRange = arr[i][j];
                
                bomb(arr, i,j,bombRange);

                checkSameNumberMaxCount(arr);
                
                reset(arr, copiedArr);
            }
        }

        System.out.println(Answer);

        return;
    }

    private static void bomb(int[][] arr, int centerX, int centerY, int bombRange) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (isInBombRange(i,j,centerX,centerY,bombRange)) {
                    arr[i][j] = BLANK;
                }
            }
        }

        for (int col = 0; col < N; ++col) {
            gravity(arr, col);
        }
    }

    private static boolean isInBombRange(int x, int y, int centerX, int centerY, int bombRange) {
        return (x == centerX || y == centerY) && Math.abs(x-centerX) + Math.abs(y-centerY) < bombRange; 
    }

    private static void gravity(int[][] arr, int col) {
        int[] tempArr = new int[N];
        int endOfTempArr = N-1;

        for (int i = N-1; i >= 0; --i) {
            if (arr[i][col] != BLANK) {
                tempArr[endOfTempArr--] = arr[i][col];
            }
        } 

        for (int i = N-1; i >= 0; --i) {
            arr[i][col] = tempArr[i];
        }
    }

    private static void checkSameNumberMaxCount(int[][] arr) {
        int result = 0;

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int d = 0; d < 4; ++d) {
                    int nx = i + DX[d];
                    int ny = j + DY[d];
                    int oppositeDirection = getOppositeDirection(d);

                    if (!isInRange(nx, ny)) continue;
                    if (arr[i][j] != arr[nx][ny]) continue;
                    if (arr[i][j] == BLANK) continue;
                    if (Visited[i][j][oppositeDirection] && Visited[nx][ny][d]) continue;
                        
                    ++result;
                    Visited[nx][ny][d] = true;
                    Visited[i][j][oppositeDirection] = true;
                }
            }
        }

        Answer = Math.max(Answer, result);
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static int getOppositeDirection(int d) {
        if (d == UP) {
            return DOWN;
        } else if (d == DOWN) {
            return UP;
        } else if (d == LEFT) {
            return RIGHT;
        }
        return LEFT;
    }

    private static void reset(int[][] arr, int[][] copiedArr) {
        Visited = new boolean[N][N][4];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                arr[i][j] = copiedArr[i][j];
            }
        }
    }
}