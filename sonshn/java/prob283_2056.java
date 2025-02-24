class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Move all non-zero elements to the front
                nums[nonZeroIndex] = nums[i];

                // Move all zero elements to the back by overwriting
                if (i != nonZeroIndex) {
                    nums[i] = 0;
                }

                nonZeroIndex++;
            }
        }
    }
}