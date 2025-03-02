import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int[] num1 : nums1) {
            map.put(num1[0], map.getOrDefault(num1[0], 0) + num1[1]);
        }

        for (int[] num2 : nums2) {
            map.put(num2[0], map.getOrDefault(num2[0], 0) + num2[1]);
        }

        int[][] answer = new int[map.size()][];
        int index = 0;
        for (int key : map.keySet()) {
            answer[index++] = new int[]{key, map.get(key)};
        }

        return answer;
    }
}