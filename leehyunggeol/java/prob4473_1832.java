import java.util.*;

public class Main {
    static int N = 0, Answer = Integer.MAX_VALUE;
    static int[] Arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        
        Arr = new int[N];
        for (int i = 0; i < N; i++) {
            Arr[i] = scanner.nextInt();
        }

        dfs(0, 0);

        if (Answer == Integer.MAX_VALUE) {
            Answer = -1;
        }

        System.out.println(Answer);
    }

    private static void dfs(int curIndex, int jump) {
        if (curIndex >= N-1) {
            Answer = Math.min(Answer, jump);
            return;
        }

        for (int i = 1; i <= Arr[curIndex]; ++i) {
            dfs(curIndex + i, jump+1);
        }
    }
}