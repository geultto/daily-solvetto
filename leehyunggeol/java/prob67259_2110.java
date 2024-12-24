import java.util.*;

class Solution {
    private static int[] DX = {-1,1,0,0};
    private static int[] DY = {0,0,-1,1};
    private static int N;
    private static int M;
    
    static class Node {
        private int x;
        private int y;
        private int direction;
        private int cost;
        
        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
        
        public int getDirection() {
            return this.direction;
        }
        
        public int getCost() {
            return this.cost;
        }
    }
    
    public int solution(int[][] board) {
        return bfs(board);
    }
    
    private int bfs(int[][] board) {
        int result = Integer.MAX_VALUE;
        N = board.length;
        M = board[0].length;
        Queue<Node> q = new LinkedList<>();
        
        int[][][] dp = new int[N][M][4];
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                for (int k = 0; k < 4; ++k) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        // int[][] dp = new int[N][M];
        // boolean[][][] visited = new boolean[N][M][4];
    
        q.add(new Node(0,0,-1,0));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.getX() == N-1 && cur.getY() == M-1) {
                result = Math.min(result, cur.getCost());
            }
            
            for (int i = 0; i < 4; ++i) {
                int nx = cur.getX() + DX[i];
                int ny = cur.getY() + DY[i];
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == 0) {
                    int newCost = cur.getCost();
                    if (cur.getDirection() == -1 || cur.getDirection() == i) {
                        newCost += 100;
                    } else {
                        newCost += 600;
                    }
                        
                    // if (!visited[nx][ny][i] || newCost <= dp[nx][ny]){
                        // visited[nx][ny][i] = true;
                    
                    if (newCost <= dp[nx][ny][i]) {
                        dp[nx][ny][i] = newCost;
                        q.add(new Node(nx, ny, i, newCost));              
                    }
                }
            }
        }
        
        return result;
    }
}