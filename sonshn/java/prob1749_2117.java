class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0; int minSum = 0;
        int maxAbsSum = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            
            maxSum = Math.max(maxSum, currentSum);
            minSum = Math.min(minSum, currentSum);

            maxAbsSum = Math.max(maxAbsSum, Math.abs(currentSum));
        }

        return Math.max(maxAbsSum, Math.abs(maxSum - minSum));
    }
}