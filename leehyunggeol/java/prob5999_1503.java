import java.util.*;

public class Main {
    static int N = 0;
    static boolean[] Vistied;
    static int[] Arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Vistied = new boolean[N];
        Arr = new int[N];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; ++i) {
                System.out.print(Arr[i]+1 + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (Vistied[i]) continue;
            Vistied[i] = true;
            Arr[depth] = i;
            dfs(depth+1);
            Vistied[i] = false;
            Arr[depth] = 0;
        }
    }
}