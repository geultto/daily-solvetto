import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {
        int answer = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        for (int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() >= 3) {
                answer += n-right;

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                ++left;
            }
        }

        return answer;
    }
}