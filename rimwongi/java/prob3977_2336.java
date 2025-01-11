public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while (n > 0) {
            if (n % 2 == 1) {
                answer += 1;
            }
            n /= 2;
        }
        return answer;
    }
}