import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Queue<Integer> times = new PriorityQueue<>();
        
        for (String time : timetable) {
            times.add(timeToInt(time));
        }
        
        int start = 540, count = 0, last = 0;
        
        for (int i = 0; i < n; ++i) {
            count = 0;
            
            while(!times.isEmpty()) {
                int current = times.peek();
                
                if (current <= start && count < m) {
                    ++count;
                    times.poll();
                    last = current - 1; 
                } else {
                    break;
                }
            }
            
            start += t;
        }
        
        if (count < m) {
            last = start - t;
        }
        
        return intToTime(last);
    }
    
    private int timeToInt(String time) {
        String[] split = time.split(":");
        return (60*Integer.parseInt(split[0])) + Integer.parseInt(split[1]);
    }
    
    private String intToTime(int time) {
        return String.format("%02d", (time/60)) + ":" + String.format("%02d", (time%60));
    }
}