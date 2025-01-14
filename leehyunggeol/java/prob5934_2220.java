import java.util.*;

public class Main {
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

        int index = 0;
        int[] query = new int[7];
        while (sc.hasNextInt()) { 
            query[index++] = sc.nextInt();
        }

        sc.close();

        rotate(arr, query);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }

    private static void rotate(int[][] arr, int[] query) {
        int r = query[0]-1;
        int c = query[1]-1;
        int[] length = new int[4];
        int[] dx;
        int[] dy;
        boolean isClockwise = query[6] == 1;

        if (isClockwise) {
            length[0] = query[5];
            length[1] = query[4];
            length[2] = query[3];
            length[3] = query[2];
            dx = new int[]{-1,-1,1,1};
            dy = new int[]{-1,1,1,-1};
        } else {
            length[0] = query[2];
            length[1] = query[3];
            length[2] = query[4];
            length[3] = query[5];
            dx = new int[]{-1,-1,1,1};
            dy = new int[]{1,-1,-1,1};
        }
        shift(arr, r,c,dx,dy,length);
    }

    private static void shift(int[][] arr, int x, int y, int[] dx, int[] dy, int[] length) {
        int temp = arr[x][y];

        for (int direction = 0; direction < 4; ++direction) {
            for (int step = 0; step < length[direction]; ++step) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                int swapTemp = arr[nx][ny];
                arr[nx][ny] = temp;
                temp = swapTemp;

                x = nx;
                y = ny;
            }
        }
    }
}