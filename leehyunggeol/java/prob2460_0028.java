class Solution {
    public int[] applyOperations(int[] nums) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length-1; ++i) {
            if (nums[i] == nums[i+1]) {
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
        }

        for (int i = 0, nonZeroIndex = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                answer[nonZeroIndex++] = nums[i];
            }
        }

        return answer;
    }
}