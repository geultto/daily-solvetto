import java.util.*;

public class Main {
    static int N = 0, M = 0, C = 0, Answer = 0, MaxWeight1 = 0, MaxWeight2 = 0;
    static int[][] Arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        M = scanner.nextInt();
        C = scanner.nextInt();
        
        Arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arr[i][j] = scanner.nextInt();
            }
        }

        int[] selected = new int[2];

        dfs(selected, 0);

        System.out.println(Answer);
    }

    private static void dfs(int[] selected, int size) {
        if (size == 2) {
            if (possible(selected)) {
                countMaxWeight(selected);
            }
            return;
        }

        for (int i = 0; i < N*N; ++i) {
            selected[size] = i;
            dfs(selected, size+1);
            selected[size] = -1;
        }
    }
    
    private static boolean possible(int[] selected) {
        if (selected[0] == selected[1]) {
            return false;
        }

        Point thief1 = new Point(selected[0]/N, selected[0]%N);
        int maxTheif1YSize = thief1.y + M-1;
        Point thief2 = new Point(selected[1]/N, selected[1]%N);
        int maxTheif2YSize = thief2.y + M-1;

        if (!isInRange(thief1.x, maxTheif1YSize)) {
            return false;
        }
        if (!isInRange(thief2.x, maxTheif2YSize)) {
            return false;
        }

        if (isSameRow(thief1.x, thief2.x)) {
            if (thief1.y < thief2.y && thief2.y <= maxTheif1YSize) {
                return false;
            }
            if (thief2.y < thief1.y && thief1.y <= maxTheif2YSize) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSameRow(int row1, int row2) {
        return row1 == row2;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static void countMaxWeight(int[] selected) {
        Point thief1 = new Point(selected[0]/N, selected[0]%N);
        Point thief2 = new Point(selected[1]/N, selected[1]%N);

        int[] selectWeight1 = new int[M];
        selectWeight1(thief1, selectWeight1, 0);

        int[] selectWeight2 = new int[M];
        selectWeight2(thief2, selectWeight2, 0);

        Answer = Math.max(Answer, MaxWeight1+MaxWeight2);

        MaxWeight1 = 0;       
        MaxWeight2 = 0;       
    }

    private static void selectWeight1(Point p, int[] selected, int size) {
        if (size == M) {
            int weight1 = countWeight(p, selected);
            MaxWeight1 = Math.max(MaxWeight1, weight1);
            return;
        }

        for (int i = 0; i < 2; ++i) {
            selected[size] = i;
            selectWeight1(p, selected, size+1);
            selected[size] = 0;
        }
    }


    private static void selectWeight2(Point p, int[] selected, int size) {
        if (size == M) {
            int weight2 = countWeight(p, selected);
            MaxWeight2 = Math.max(MaxWeight2, weight2);
            return;
        }

        for (int i = 0; i < 2; ++i) {
            selected[size] = i;
            selectWeight2(p, selected, size+1);
            selected[size] = 0;
        }
    }

    private static int countWeight(Point p, int[] selected) {
        int result = 0;
        int sum = 0;
        int x = p.x;

        for (int j = 0; j < M; ++j) {
            int ny = p.y + j;
        
            if (selected[j] == 1) {
                sum += Arr[x][ny];
                result += (Arr[x][ny]*Arr[x][ny]);
                if (sum > C) {
                    return 0;
                }
            }
        }

        return result;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}