import java.util.*;

public class Main {
    static int N = 0;
    static int[] dp = new int[20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= N; ++i) {
            for (int j = 0; j <= i-1; ++j) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        System.out.println(dp[N]);
    }

}