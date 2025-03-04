import java.util.*;

class Solution {
    public boolean checkPowersOfThree(int n) {
        boolean answer = true;

        for (char c : Integer.toString(n, 3).toCharArray()) {
            if (c == '2') {
                answer = false;
                break;
            }
        }

        return answer;
    }
}