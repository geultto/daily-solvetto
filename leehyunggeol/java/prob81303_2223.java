import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> deleted = new Stack<>();
        int tableSize = n;
        
        for (String c : cmd) {
            char command = c.charAt(0);
            if (command == 'U') {
                int X = Integer.parseInt(c.split(" ")[1]);
                k -= X;
            } else if (command == 'D') {
                int X = Integer.parseInt(c.split(" ")[1]);
                k += X;
            } else if (command == 'C') {
                deleted.add(k);
                
                --tableSize;
                if (k == tableSize) {
                    --k;
                }
            } else if (command == 'Z') {
                int row = deleted.pop();
                
                ++tableSize;
                if (k >= row) {
                    ++k;
                }
            }   
        }
        
        for (int i = 0; i < tableSize; ++i) {
            answer.append("O");
        }
        
        while (!deleted.isEmpty()) {
            answer.insert(deleted.pop(), "X");
        }
        
        return answer.toString();
    }
}