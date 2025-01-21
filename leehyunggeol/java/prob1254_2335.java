import java.util.*;

public class Main {
    private static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    private static final char WALL = '#';

    private static int N = 0;
    private static int[] DX = {-1,1,0,0};
    private static int[] DY = {0,0,-1,1};
    private static boolean[][][] Visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int x = sc.nextInt()-1;
        int y = sc.nextInt()-1;
        sc.nextLine(); 

        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine(); 
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j); 
            }
        }

        sc.close(); 
        
        int direction = RIGHT;
        int answer = 0;
        Visited = new boolean[N][N][4];

        while (isInRange(x, y)) {
            if (Visited[x][y][direction]) {
                answer = -1;
                break;
            }

            Visited[x][y][direction] = true;

            int nx = x + DX[direction];
            int ny = y + DY[direction];

            if (isWall(arr, nx, ny)) {
                direction = getCCWDirection(direction);
                continue;
            } 
            if (!isInRange(nx, ny)) {
                x = nx;
                y = ny;
                ++answer;
                continue;        
            } 
            if (isRightWall(arr, nx, ny, direction)) {
                x = nx;
                y = ny;
                ++answer;
                continue;                
            } else {
                x = nx;
                y = ny;
                direction = getCWDirection(direction);
                x += DX[direction];
                y += DY[direction];
                answer += 2;
            }
        }

        System.out.println(answer);
    }

    private static boolean isWall(char[][] arr, int x, int y) {
        return isInRange(x,y) && arr[x][y] == WALL;
    }

    private static boolean isInRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }

    private static boolean isRightWall(char[][] arr, int x, int y, int direction) {
        if (direction == UP) {
            return arr[x][y+1] == WALL;
        } else if (direction == DOWN) {
            return arr[x][y-1] == WALL;
        } else if (direction == LEFT) {
            return arr[x-1][y] == WALL;
        }
        return arr[x+1][y] == WALL;
    }
    
    private static int getCCWDirection(int direction) {
        if (direction == UP) {
            return LEFT;
        } else if (direction == DOWN) {
            return RIGHT;
        } else if (direction == LEFT) {
            return DOWN;
        }
        return UP;
    }

    private static int getCWDirection(int direction) {
        if (direction == UP) {
            return RIGHT;
        } else if (direction == DOWN) {
            return LEFT;
        } else if (direction == LEFT) {
            return UP;
        }
        return DOWN;
    }
}