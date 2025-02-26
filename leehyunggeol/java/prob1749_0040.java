class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(nums[i], max+nums[i]);
            min = Math.min(nums[i], min+nums[i]);
            maxSum = Math.max(maxSum, max);
            minSum = Math.min(minSum, min);
        }

        return Math.abs(maxSum) > Math.abs(minSum) ? Math.abs(maxSum) : Math.abs(minSum);
    }
}