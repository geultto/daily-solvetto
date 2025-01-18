import java.util.*;

public class Main {
    private static final int BLANK = 0;
    private static int N = 0, M = 0, K = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        sc.close();

        N = n;
        M = m;
        K = k;

        while (K > 0) {
            for (int col = 0; col < N; ++col) {
                bomb(arr, col);
            }

            arr = rotate90Clockwise(arr);

            for (int j = 0; j < N; ++j) {
                gravity(arr, j);
            }

            --K;
        }

        for (int col = 0; col < N; ++col) {
            bomb(arr, col);
        }

        int answer = 0;      
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (arr[i][j] != BLANK) {
                    ++answer;
                }
            }
        }
        System.out.println(answer);
        return;
    }

    private static void bomb(int[][] arr, int col) {
        while (true) {
            boolean isExploded = false;

            for (int i = N-1; i >= 0; --i) {
                if (arr[i][col] == BLANK) {
                    continue;
                }

                int end = getEndIndexOfSameNumberBomb(arr, i, col, arr[i][col]);

                if (i - end + 1 >= M) {
                    explosion(arr, i, end, col);
                    isExploded = true;
                }
            }

            if (isExploded) {
                gravity(arr, col);
            } else {
                break;
            }
        }
    }

    private static int getEndIndexOfSameNumberBomb(int[][] arr, int start, int col, int num) {
        int end = start;

        for (int i = start-1; i >= 0; --i) {
            if (arr[i][col] == num) {
                end = i;
            } else {
                break;
            }
        }

        return end;
    }

    private static void explosion(int[][] arr, int start, int end, int col) {
        for (int i = start; i >= end; --i) {
            arr[i][col] = BLANK;
        }
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

    private static int[][] rotate90Clockwise(int[][] arr) {
        int[][] rotated = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[j][N- 1 - i] = arr[i][j];
            }
        }
        return rotated;
    }
}