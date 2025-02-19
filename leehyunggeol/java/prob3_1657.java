// 점화식
// dp[i] = dp[i - 1] * 2 + dp[i - 2] * 3 +
//         (dp[i - 3] + dp[i - 4] + dp[i - 5] + ... dp[0]) * 2
// i가 0인 경우에는 타일을 전혀 놓지 않는 경우가 한 가지 있으므로 의미상 1이 됩니다..?

import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static int N = 0;
    static long[] dp = new long[1_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3) % MOD; {
            for (int j = i - 3; j >= 0; j--)
                dp[i] = (dp[i] + dp[j] * 2) % MOD;
            }
        }

        System.out.println(dp[N]);
    }
}