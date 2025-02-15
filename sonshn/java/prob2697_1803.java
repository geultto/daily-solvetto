import java.util.*;

class Solution {
    public String makeSmallestPalindrome(String s) {
        // String -> Char형 배열 
        char[] charArr = s.toCharArray();

        for(int i=0; i<s.length()/2; i++) {
            // 두 문자 간 ASCII Code 값을 비교하는 방법: 그냥 부등호로 바로 비교 가능
            if(s.charAt(i) > s.charAt(s.length()-1-i)) {
                charArr[i] = charArr[s.length()-1-i];
            } else if (s.charAt(i) < s.charAt(s.length()-1-i)) {
                charArr[s.length()-1-i] = charArr[i];
            }
        }

        // Char형 배열 -> String
        String answer = new String(charArr);

        return answer;
    }
}