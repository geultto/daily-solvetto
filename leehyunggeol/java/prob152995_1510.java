import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] wanho = scores[0];
        int wanhoSum = scores[0][0]+scores[0][1];
        
        Arrays.sort(scores, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1]-b[1];
                }
                return b[0]-a[0];
            }
        });
        
        int maxPeerScore = 0;
        for (int i = 0; i < scores.length; ++i) {
            int attitude = scores[i][0];
            int peer = scores[i][1];
            
            if (peer < maxPeerScore) {
                if (wanho[0] == attitude && wanho[1] == peer) {
                    return -1;
                }
                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                maxPeerScore = peer;
            }
        }
        
        Arrays.sort(scores, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return (b[0]+b[1]) - (a[0]+a[1]);
            }
        });
        
        for (int[] score : scores) {
            if (score[0]+score[1] > wanhoSum) {
                ++answer;
            }
        }
        
        return answer;
    }
}