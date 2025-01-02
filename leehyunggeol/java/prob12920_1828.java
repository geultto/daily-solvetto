class Solution {
    public int solution(int n, int[] cores) {
        if (n <= cores.length) {
            return n;
        }
        
        int left = 1, right = 10_000*n, mid = 0, time = 0, work = 0;
        
        while (left <= right) {
            mid = (left+right)/2;
            
            int count = countTask(mid, cores);
            
            if (count >= n) {
                right = mid-1;
                time = mid;
                work = count;
            } else {
                left = mid+1;
            }
        }
                
        work -= n;
        
        int answer = 0;
        for (int i = cores.length-1; i >= 0; --i) {
            if (time % cores[i] == 0){
                if (work == 0) {
                    answer = i+1;
                    break;
                }
                --work;
            }
        }
        
        return answer;
    }
    
    private int countTask(int time, int[] cores) {
        int count = cores.length;
        
        for (int duration : cores) {
            count += time/duration;
        }
        
        return count;
    }
}