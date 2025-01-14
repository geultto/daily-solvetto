import java.util.*;

public class Main {
    private static final int BLANK = 0;
    private static int N = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;

        sc.close();

        N = n;

        bomb(arr, r, c);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }

    private static void bomb(int[][] arr, int x, int y) {
        int length = arr[x][y]-1;

        // for (int i = x-length; i <= x+length; ++i) {
        //     if (isInRange(i,y)) {
        //         arr[i][y] = 0;
        //     }
        // }

        // for (int j = y-length; j <= y+length; ++j) {
        //     if (isInRange(x,j)) {
        //         arr[x][j] = 0;
        //     }
        // }

        int bombRange = arr[x][y];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (isInBombRange(x,y,i,j, bombRange)) {
                    arr[i][j] = BLANK;
                }
            }
        }

        for (int j = 0; j < N; ++j) {
            gravity(arr, j);
        }
    }

    private static void gravity(int[][] arr, int y) {
        int[] tempArr = new int[N];
        int endOfTempArr = N-1;
        
        for (int i = N-1; i >= 0; --i) {
            if (arr[i][y] != BLANK) {
                tempArr[endOfTempArr--] = arr[i][y];
            }
        }

        for (int i = N-1; i >= 0; --i) {
            arr[i][y] = tempArr[i];
        }
    }

    private static boolean isInBombRange(int centerX, int centerY, int x, int y, int bombRange) {
        return (centerX == x || centerY == y) && (Math.abs(x-centerX) + Math.abs(y-centerY) < bombRange); 
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}