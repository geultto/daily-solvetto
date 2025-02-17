class Solution {
    public boolean isArraySpecial(int[] nums) {
        int length = nums.length;
        boolean isSpecial = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i+1] % 2) {
                isSpecial = false;
            }
        }

        return isSpecial;
    }
}