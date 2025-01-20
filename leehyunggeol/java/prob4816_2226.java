import java.util.*;

public class Main {
    private static final int BLANK = 0;
    private static int N = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] cols = new int[m];
        for (int i = 0; i < m; i++) {
            cols[i] = sc.nextInt()-1;
        }

        sc.close();

        N = n;

        for (int col : cols) {
            bomb(arr, col);
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }

    private static void bomb(int[][] arr, int col) {
        int row = 0;
        for (int i = 0; i < N; ++i) {
            if (arr[i][col] != BLANK) {
                row = i;
                break;
            }
        }

        int bombRange = arr[row][col];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (isInBombRange(i,j,row,col,bombRange)) {
                    arr[i][j] = BLANK;
                }
            }
        }

        for (int j = 0; j < N; ++j) {
            gravity(arr, j);
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

    private static boolean isInBombRange(int x, int y, int centerX, int centerY, int bombRange) {
        return (x == centerX || y == centerY) && Math.abs(x-centerX) + Math.abs(y-centerY) < bombRange;
    }
}