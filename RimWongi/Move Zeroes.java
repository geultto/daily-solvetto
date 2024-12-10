class Solution {
    /**
    두 개의 포인터를 이용하여서 배열의 맨 앞을 가리킨다
    하나는 값이 0인 배열의 인덱스를 다른 하나는 0이 아닌 배열의 인덱스를 찾아
    서로 위치를 바꾸기
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, index);
                index++;
            }
        }
    }

    void swap(int[] nums, int i, int idx) {
        int tmp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = tmp;
    }
}