class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        int n = arr.length;
        // dp[i][0] : i번째까지 고려할 때, i에서 끝나는 부분 배열 중 짝수 합의 개수
        // dp[i][1] : i번째까지 고려할 때, i에서 끝나는 부분 배열 중 홀수 합의 개수
        int[][] dp = new int[n][2];
        
        // 초기값 설정
        if (arr[0] % 2 == 0) {
            dp[0][0] = 1;
            dp[0][1] = 0;
        } else {
            dp[0][0] = 0;
            dp[0][1] = 1;
        }
        
        int ans = dp[0][1]; // 첫 번째 원소에 대해 홀수이면 더함
        
        // 점화식에 따라 dp 배열 채우기
        for (int i = 1; i < n; i++) {
            if (arr[i] % 2 == 0) {
                // 현재 원소가 짝수: 합의 홀짝이 바뀌지 않음
                dp[i][0] = (dp[i-1][0] + 1) % mod;
                dp[i][1] = dp[i-1][1];
            } else {
                // 현재 원소가 홀수: 홀수와 짝수의 역할이 교환됨
                dp[i][0] = dp[i-1][1];
                dp[i][1] = (dp[i-1][0] + 1) % mod;
            }
            ans = (ans + dp[i][1]) % mod;
        }
        
        return ans;
    }
}