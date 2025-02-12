class Solution {
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> digitSumMap = new HashMap<>();
        for (int num : nums) {
            int sum = digitSum(num);
            digitSumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(num);
        }
        int maxSum = -1;
        
        for (List<Integer> numbers : digitSumMap.values()) {
            if (numbers.size() >= 2) {
                Collections.sort(numbers, Collections.reverseOrder());
                maxSum = Math.max(maxSum, numbers.get(0) + numbers.get(1));
            }
        }
        return maxSum;
    }
}