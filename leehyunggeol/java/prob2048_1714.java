import java.util.*;

public class Main {
    private static final int BLANK = 0;
    private static int N = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 4;  
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        char direction = sc.next().charAt(0);

        sc.close();

        N = n;

        tilt(arr, direction);
        
        print(arr);
        
        return;
    }

    private static void tilt(int[][] arr, char direction) {
        int moveCount = 0;

        if (direction == 'L') {
            moveCount = 3;
        } else if (direction == 'R') {
            moveCount = 1;
        } else if (direction == 'U') {
            moveCount = 2;
        } else if (direction == 'D') {
            moveCount = 0;
        }

        for (int i = 0; i < moveCount; ++i) {
            rotate(arr);
        }

        gravity(arr);
        assembleNumber(arr);
        gravity(arr);

        for (int i = 0; i < 4-moveCount; ++i) {
            rotate(arr);
        }
    }

    // grid를 시계방향으로 90' 회전시킵니다.
    private static void rotate(int[][] arr) {
        int[][] temp = new int[N][N];
        // nextGrid를 0으로 초기화합니다.
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                temp[i][j] = 0;
        
        // 90' 회전합니다.
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                temp[i][j] = arr[N -j- 1][i];
        
        // nextGrid를 grid에 옮겨줍니다.
         for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                arr[i][j] = temp[i][j];
    }

    private static void gravity(int[][] arr) {
        for (int j = 0; j < N; ++j) {
            int[] temp = new int[N];
            int endOfTempArr = N-1;
            for (int i = N-1; i >= 0; --i) {
                if (arr[i][j] != BLANK) {
                    temp[endOfTempArr--] = arr[i][j];
                }
            }
            for (int i = N-1; i >= 0; --i) {
                arr[i][j] = temp[i];
            }
        }
    }

    private static void assembleNumber(int[][] arr) {
        for (int j = 0; j < N; ++j) {
            for (int i = N-1; i > 0; --i) {
                if (arr[i-1][j] == arr[i][j]) {
                    arr[i][j] += arr[i-1][j];
                    arr[i-1][j] = BLANK;
                }
            }
        }
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}