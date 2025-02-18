import java.util.*;

class Solution {
    public String smallestNumber(String pattern) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        StringBuilder answer = new StringBuilder();

        int num = 1;

        for(int i=0; i<=pattern.length(); i++) {
            deque.push(num++);

            if(i == pattern.length() || pattern.charAt(i) == 'I') {
                while(!deque.isEmpty()) {
                    answer.append(deque.pop());
                }
            }
        }

        return answer.toString();
    }
}