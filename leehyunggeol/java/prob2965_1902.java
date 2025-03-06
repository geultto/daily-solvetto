import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n = 1; n <= grid.length*grid.length; ++n) {
            map.put(n, 0);
        }

        for (int[] arr : grid) {
            for (int x : arr) {
                map.put(x, map.get(x) + 1);
            }
        }

        int[] answer = new int[2];
        for (int x : map.keySet()) {
            int count = map.get(x);
            if (count == 2) {
                answer[0] = x;
            } else if (count == 0) {
                answer[1] = x;
            }
        }

        return answer;
    }
}