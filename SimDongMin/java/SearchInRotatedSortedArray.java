class Solution {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int m;

        while (left <= right) {
            m = left + (right - left) / 2;

            if (nums[m] == target) {
                return m;
            }

            if (nums[left] <= nums[m]) {
                /// 왼쪽이 정렬되어 있군
                if (target >= nums[left]&& target < nums[m]) {
                    right = m - 1;
                } else {
                    left = m + 1;
                }
            } else {
                if (target > nums[m] && target <= nums[right]) {
                    left = m + 1;
                } else {
                    right = m - 1;
                }
            }
        }

        return -1;
    }
}