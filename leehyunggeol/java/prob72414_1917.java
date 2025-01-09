import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int totalPlayTime = timeToNum(play_time);
        int[] playTimes = new int[totalPlayTime+1];
                
        for (String log : logs) {
            String[] split = log.split("-");
            int startTime = timeToNum(split[0]);
            int endTime = timeToNum(split[1]);
            
            ++playTimes[startTime];
            --playTimes[endTime];
        }
        
        for (int i = 1; i < totalPlayTime; ++i) {
            playTimes[i] += playTimes[i-1];
        }
        
        int advTime = timeToNum(adv_time);
        long sum = Arrays.stream(playTimes, 0, advTime).sum();
        long maxSum = sum;
        int maxStartTime = 0;
        
        for (int i = advTime; i < totalPlayTime; ++i) {
            sum += playTimes[i];
            sum -= playTimes[i-advTime];
            
            if (sum > maxSum) {
                maxSum = sum;
                maxStartTime = i-advTime+1;
            }
        }
        
        return numToTime(maxStartTime);
    }
    
    private int timeToNum(String time) {
        String[] split = time.split(":");
        return (Integer.parseInt(split[0])*3600) + (Integer.parseInt(split[1])*60) + Integer.parseInt(split[2]);
    }
    
    private String numToTime(int num) {
        return String.format("%02d:%02d:%02d", num/3600, (num%3600)/60, num%60);
    }
}