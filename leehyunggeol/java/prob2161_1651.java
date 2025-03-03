class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] answer = new int[nums.length];

        int index = 0;
        for (int n : nums) {
            if (n < pivot) {
                answer[index++] = n;
            }
        }

        for (int n : nums) {
            if (n == pivot) {
                answer[index++] = n;
            }
        }

        for (int n : nums) {
            if (n > pivot) {
                answer[index++] = n;
            }
        }

        return answer;
    }
}