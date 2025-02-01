class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = findStartIndex(nums, target, 0, nums.length - 1);
        int end = findLastIndex(nums, target, start, nums.length - 1) - 1;

        if (start >= nums.length || start > end) {
            return new int[] {-1, -1};
        }

        return new int[] {start, end};
    }

    // lowerBound
    public int findStartIndex(int[] nums, int target, int lw, int hi) {
        while (lw <= hi) {
            int mid = lw + (hi - lw) / 2;
            if (target <= nums[mid]) hi = mid - 1;
            else lw = mid + 1;
        }

        return lw;
    }

    // upperBound
    public int findLastIndex(int[] nums, int target, int lw, int hi) {
        while (lw <= hi) {
            int mid = lw + (hi - lw) / 2;
            if (target < nums[mid]) hi = mid - 1;
            else lw = mid + 1;
        }

        return lw;
    }
}