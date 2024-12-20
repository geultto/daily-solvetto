class Solution {
    public long solution(int n, int[] times) {
        long answer = 0, left = 0, right = (long) 1e18;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (isPossible(times, n, mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean isPossible(int[] times, int n, long minTime) {
        long people = n;
        for (int time : times) {
            people -= (minTime / (long)time);
            if (people <= 0) {
                return true;
            }
        }
        return false;
    }
}