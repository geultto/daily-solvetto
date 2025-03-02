import java.util.*;

public class Main {
    static int N = 0, Answer = 0;
    static Line[] Arr;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Arr = new Line[N];
        dp = new int[N];

        for (int i = 0; i < N; ++i) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int cost = sc.nextInt();

            Arr[i] = new Line(l,r,cost);
            dp[i] = cost;
        }

        dp[0] = Arr[0].cost;

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (Arr[j].r < Arr[i].l) {
                    dp[i] = Math.max(dp[i], dp[j] + Arr[i].cost);
                }
            }
            Answer = Math.max(Answer, dp[i]);
        }

        System.out.println(Answer);
    }

    static class Line {
        int l,r,cost;

        public Line(int l, int r, int cost) {
            this.l = l;
            this.r = r;
            this.cost = cost;
        }
    }
}