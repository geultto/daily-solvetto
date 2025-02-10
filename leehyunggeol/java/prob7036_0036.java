import java.util.*;

class Solution {
    static int N = 0;
    static int[] DX = {-1,-1,-1,0,0,0,1,1,1};
    static int[] DY = {-1,0,1,-1,0,1,-1,0,1};
    
    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        int[][] counter = new int[N][N];
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (board[i][j] == 1) {
                    for (int d = 0; d < 9; ++d) {
                        int nx = i + DX[d];
                        int ny = j + DY[d];
                        if (isInRange(nx,ny)) {
                            counter[nx][ny] = 1;
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (counter[i][j] == 1) {
                    ++answer;
                }
            }
        }
        
        return (N*N)-answer;
    }
    
    private boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}