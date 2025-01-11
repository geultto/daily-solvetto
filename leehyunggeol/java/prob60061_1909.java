import java.util.*;

class Solution {
    
    private static int[][] Pillars;
    private static int[][] Bars;
    private static int N = 0;
        
    public int[][] solution(int n, int[][] build_frame) {
        Pillars = new int[n+1][n+1];
        Bars = new int[n+1][n+1];
        N = n;
        
        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            boolean isPillarOrNot = frame[2] == 0;
            boolean isInstallingOrNot = frame[3] == 1;
            
            if (isPillarOrNot) {
                if (isInstallingOrNot && canExistPillar(x,y)) {
                    Pillars[x][y] = 1;
                } else {
                    Pillars[x][y] = 0;
                    if (canDestroy(x,y) == false) {
                        Pillars[x][y] = 1;
                    }
                }
            } else {
                if (isInstallingOrNot && canExistBar(x,y)) {
                    Bars[x][y] = 1;
                } else {
                    Bars[x][y] = 0;
                    if (canDestroy(x,y) == false) {
                        Bars[x][y] = 1;
                    }
                }
            }
        }
        
        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i <= N; ++i) {
            for (int j = 0; j <= N; ++j) {
                if (Pillars[i][j] == 1) {
                    answer.add(new int[]{i,j,0});
                }
                if (Bars[i][j] == 1) {
                    answer.add(new int[]{i,j,1});
                }
            }
        }
        
        return answer.toArray(new int[0][]);
    }
    
    private boolean canExistPillar(int x, int y) {
        if (y == 0) {
            return true;
        } else if (inRange(x,y-1) && Pillars[x][y-1] == 1) {
            return true;
        } else if ((inRange(x-1,y) && Bars[x-1][y] == 1) || Bars[x][y] == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean canExistBar(int x, int y) {
        if ((inRange(x,y-1) && Pillars[x][y-1] == 1) || (inRange(x+1,y-1) && Pillars[x+1][y-1] == 1)) {
            return true;
        } else if ((inRange(x-1,y) && Bars[x-1][y] == 1) && (inRange(x+1,y) && Bars[x+1][y] == 1)) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean canDestroy(int x, int y) {
        for (int i = x-1; i <= x+1; ++i) {
            for (int j = y; j <= y+1; ++j) {
                if (inRange(i,j)) {
                    if (Pillars[i][j] == 1 && canExistPillar(i,j) == false) {
                        return false;
                    }
                    if (Bars[i][j] == 1 && canExistBar(i,j) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean inRange(int x, int y) {
        return 0 <= x && x <= N && 0 <= y && y <= N;
    }
}