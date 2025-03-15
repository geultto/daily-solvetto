import java.util.*;

class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 0, right = 0;
        for (int n : nums) {
            left = Math.min(left, n);
            right = Math.max(right, n);
        }

        while (left < right) {
            int mid = (left + right) / 2;

            if (canStealKHouses(nums, mid, k)) {
                right = mid; 
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canStealKHouses(int[] nums, int capability, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= capability) {
                ++count;
                ++i;
            }
        }

        return count >= k;
    }
}