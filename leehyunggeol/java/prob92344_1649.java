import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] prefixSum = new int[n+1][m+1];
        
        for (int[] info : skill) {
            int type = info[0];
            int r1 = info[1], c1 = info[2], r2 = info[3], c2 = info[4];
            int degree = type == 1 ? -info[5] : info[5];
            
            prefixSum[r1][c1] += degree;
            prefixSum[r2+1][c1] -= degree;
            prefixSum[r1][c2+1] -= degree;
            prefixSum[r2+1][c2+1] += degree;
        }
        
        for(int y = 0; y < m; ++y) {
            for(int x = 1; x < n; ++x) {
                prefixSum[x][y] += prefixSum[x-1][y];
            }
        }
        
        for(int x = 0; x < n; ++x) {
            for(int y = 1; y < m; ++y) {
                prefixSum[x][y] += prefixSum[x][y-1];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                board[i][j] += prefixSum[i][j];
                if (board[i][j] > 0) {
                    ++answer;
                }
            }
        }
        
        return answer;
    }
}