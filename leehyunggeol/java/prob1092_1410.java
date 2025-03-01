import java.util.*;

class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        // dp[row][col] : str1의 첫 row, str2의 첫 col로 만들 수 있는 SCS의 길이
        int[][] dp = new int[str1Length + 1][str2Length + 1];

        // Base case: 한쪽이 빈 문자열일 때의 SCS 길이
        for (int row = 0; row <= str1Length; row++) {
            dp[row][0] = row;
        }
        for (int col = 0; col <= str2Length; col++) {
            dp[0][col] = col;
        }

        // DP 테이블 채우기
        for (int row = 1; row <= str1Length; row++) {
            for (int col = 1; col <= str2Length; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + 1;
                }
            }
        }

        // Backtracking을 통해 SCS 재구성
        StringBuilder supersequence = new StringBuilder();
        int row = str1Length, col = str2Length;

        while (row > 0 && col > 0) {
            if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                // 문자가 같으면, 해당 문자를 결과에 추가하고 대각선으로 이동
                supersequence.append(str1.charAt(row - 1));
                row--;
                col--;
            } else if (dp[row - 1][col] < dp[row][col - 1]) {
                // str1의 문자를 포함하는 쪽이 더 짧다면
                supersequence.append(str1.charAt(row - 1));
                row--;
            } else {
                // 그렇지 않으면, str2의 문자를 포함하는 쪽으로 이동
                supersequence.append(str2.charAt(col - 1));
                col--;
            }
        }

        // 남은 문자 처리 (한쪽 문자열이 남은 경우)
        while (row > 0) {
            supersequence.append(str1.charAt(row - 1));
            row--;
        }
        while (col > 0) {
            supersequence.append(str2.charAt(col - 1));
            col--;
        }

        // 결과 문자열은 역순으로 구성되었으므로 뒤집어서 반환
        return supersequence.reverse().toString();
    }
}