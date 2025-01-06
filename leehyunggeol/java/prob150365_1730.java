import java.util.*;

// bfs, dfs 완전탐색, 플로이드 워셜?
// 같은 노드를 여러번 방문 가능하다...

class Solution {
    private static int[] DX = {1,0,0,-1};
    private static int[] DY = {0,-1,1,0};
    private static String[] Path = {"d","l","r","u"};
    private static String Answer = "";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        if (isNotPossible(x,y,r,c,k)) {
            return "impossible";
        }
        
        dfs(n,m,x,y,r,c,k,0,"");
                
        return Answer;
    }
    
    private boolean isNotPossible(int x, int y, int r, int c, int k) {
        int distance = getDistance(x,y,r,c);
        
        if (distance > k) {
            return true;
        } else if (distance == k) {
            return false;
        } else {
            if ((k-distance)%2 == 0) {
                return false;
            } else {
                return true;
            }
        }
    }
    
    private int getDistance(int x, int y, int r, int c) {
        return Math.abs(x-r) + Math.abs(y-c);
    }
    
    private void dfs(int n, int m, int x, int y, int r, int c, int k, int count, String path) {
        if (Answer.length() != 0 || (count + getDistance(x,y,r,c) > k)) {
            return;
        }
        if (size == k && x == r && y == c) {
            Answer = path;
            return;
        }
        
        for (int i = 0; i < 4; ++i) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            
            if (inRange(nx, ny, n, m)) {
                dfs(n,m,nx,ny,r,c,k,count+1,path+Path[i]);
            }
        }
    }
    
    private boolean inRange(int x, int y, int n, int m) {
        return 0 < x && x <= n && 0 < y && y <= m;
    }
}