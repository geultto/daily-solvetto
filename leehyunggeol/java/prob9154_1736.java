import java.util.*;

public class Main {
    private static int N = 0, M = 0;
    private static int[] DX = {-1,1,0,0};
    private static int[] DY = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt(); 
        int r = sc.nextInt()-1; 
        int c = sc.nextInt()-1; 

        sc.close(); 

        N = n;
        M = m;

        boolean[][] arr = new boolean[N][N];
        int time = 0;
        Set<Point> bombs = new HashSet<>();
        bombs.add(new Point(r,c));

        while (time <= M) {
            for (Point bomb : bombs) {
                bomb(arr, bomb, time);
            }
            bombs = getBombs(arr);
            ++time;
        }

        System.out.println(bombs.size());
    }

    private static void bomb(boolean[][] arr, Point bomb, int time) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (isBombRange(i,j,bomb.x, bomb.y, time)) {
                    arr[i][j] = true;
                }
            }
        }
    }

    private static Set<Point> getBombs(boolean[][] arr) {
        Set<Point> result = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (arr[i][j]) {
                    result.add(new Point(i,j));
                }
            }
        }
        return result;
    }

    private static boolean isBombRange(int x, int y, int centerX, int centerY, int time) {
        return isInRange(x,y) && (x == centerX || y == centerY) && Math.abs(x-centerX) + Math.abs(y-centerY) == getBombRange(time);
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static int getBombRange(int time) {
        if (time == 0) {
            return 0;
        }
        return (int) Math.pow(2, time-1);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}