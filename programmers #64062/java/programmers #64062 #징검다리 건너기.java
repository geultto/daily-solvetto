import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0, left = 0, right = 200_000_000;
        
        while (left <= right) {
            int mid = (right + left) / 2;
            
            if (isPossibleCount(stones, mid, k)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean isPossibleCount(int[] stones, int friends, int k) {
        int count = 0;
        
        for (int stone : stones) {
            if (stone < friends) {
                ++count;
                if (count == k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        
        return true;
    }
}