import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int index = 0, totalDuration = 0, answer = 0;
        Queue<int[]> diskController = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        
        Arrays.sort(jobs, (a,b) -> a[0]-b[0]);
        
        while(!diskController.isEmpty() || index < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= totalDuration) {
                diskController.add(jobs[index++]);
            }
            if (diskController.isEmpty()) {
                totalDuration = jobs[index][0];
                diskController.add(jobs[index++]);
            } else {
                int[] currentTask = diskController.poll();
                totalDuration += currentTask[1];
                answer += (totalDuration - currentTask[0]);
            }
        } 
        
        return answer / jobs.length;
    }
}