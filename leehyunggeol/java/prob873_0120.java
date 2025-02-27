import java.util.*;

class Solution {
    
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int ans = 0;
        // 모든 가능한 두 수를 시작으로 시도
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = arr[i], y = arr[j];
                int length = 2;
                // Fibonacci-like 조건: x + y가 존재하면 시퀀스를 확장
                while (set.contains(x + y)) {
                    int z = x + y;
                    x = y;
                    y = z;
                    length++;
                }
                if (length >= 3) {
                    ans = Math.max(ans, length);
                }
            }
        }
        return ans;
    }
}