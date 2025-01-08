class Solution {
    public int maxProduct(int[] nums) {
        int answer = nums[0];
        int max = nums[0];
        int min = nums[0];

        for(int i = 1; i<nums.length; i++) {
            int now = nums[i];
            int tempMax = max * now;
            int tempMin = min * now;

            max = Math.max(now, Math.max(tempMax, tempMin));
            min = Math.min(now, Math.min(tempMax, tempMin));

            answer = Math.max(answer, max);
        }

        return answer;
    }
};