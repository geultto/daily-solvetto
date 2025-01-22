import java.util.*;

public class Main {
    private static final int LEFT = 0, RIGHT = 1, UP = 2, DOWN = 3;
    public static final int ASCII_NUM = 128;

    private static int N = 0;
    private static int[] Dice = {1,2,3};
    private static int[] DX = {0,0,-1,1};
    private static int[] DY = {-1,1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt(); 
        int r = sc.nextInt()-1; 
        int c = sc.nextInt()-1; 
        sc.nextLine(); 

        String[] directions = sc.nextLine().split(" ");

        sc.close();

        N = n;

        int[][] arr = new int[N][N];
        // int d = -1;
        int[] dirMapper = new int[ASCII_NUM];
        dirMapper['L'] = 0;
        dirMapper['R'] = 1;
        dirMapper['U'] = 2;
        dirMapper['D'] = 3;

        arr[r][c] = getBottomNumberOfDice(Dice);

        for (String direction : directions) {
            int d = dirMapper[direction.charAt(0)];
            int nx = r + DX[d];
            int ny = c + DY[d];

            if (!isInRange(nx, ny)) continue;

            setNextDice(Dice, d);
            arr[nx][ny] = getBottomNumberOfDice(Dice);
            r = nx;
            c = ny;      
        }

        int answer = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (arr[i][j] == 0) continue;
                answer += arr[i][j];
            }
        }

        System.out.println(answer);
    }

    // private static int getDirection(String direction) {
    //     int d = direction.charAt(0);
    //     if (d == 'L') {
    //         return LEFT;
    //     } else if (d == 'R') {
    //         return RIGHT;
    //     } else if (d == 'U') {
    //         return UP;
    //     }
    //     return DOWN;
    // }

    private static int getBottomNumberOfDice(int[] dice) {
        return 7-dice[0];
    }

    private static void setNextDice(int[] dice, int direction) {
        if (direction == LEFT) {
            int temp = dice[0];
            dice[0] = dice[2];
            dice[2] = 7-temp;
        } else if (direction == RIGHT) {
            int temp = dice[2];
            dice[2] = dice[0];
            dice[0] = 7-temp;
        } else if (direction == UP) {
            int temp = dice[0];
            dice[0] = dice[1];
            dice[1] = 7-temp;
        } else if (direction == DOWN) {
            int temp = dice[1];
            dice[1] = dice[0];
            dice[0] = 7-temp;
        } 
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}