class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] prefixSum = new int[nums.length+1];

        for (int[] query : queries) {
            int l = query[0], r = query[1];
            ++prefixSum[l];
            --prefixSum[r+1];
        }

        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += prefixSum[i];
            if (sum < nums[i]) {
                return false;
            }
        }

        return true;
    }
}