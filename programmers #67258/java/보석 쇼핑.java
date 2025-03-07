import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int distance = Integer.MAX_VALUE, start = 0, end = 0;
        int totalGemKind = new HashSet<>(Arrays.asList(gems)).size();
        Map<String, Integer> gemCounter = new HashMap<>();
        
        while (true) {
            if (gemCounter.size() == totalGemKind) {
                gemCounter.put(gems[start], gemCounter.get(gems[start]) - 1);
                if (gemCounter.get(gems[start]) == 0) {
                    gemCounter.remove(gems[start]);
                }
                ++start;
            } else if (end == gems.length) {
                break;
            } else {
                gemCounter.put(gems[end], gemCounter.getOrDefault(gems[end], 0) + 1);
                ++end;
            }
            
            if (gemCounter.size() == totalGemKind && end-start < distance) {
                distance = end-start;
                answer[0] = start+1;
                answer[1] = end;                
            }
        }
        
        
        return answer;
    }
}