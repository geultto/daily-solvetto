class Solution {
    public int minOperations(int[] nums, int k) {
        int operations = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            if (num < k) pq.add(num);
        }

        while (!pq.isEmpty()) {
            int x = pq.poll();
            operations++;
            if (pq.isEmpty()) 
                break;

            int y = pq.poll();
            long newValue = 2L * x + y;

            if (newValue < k) 
                pq.add((int) newValue);
        }
        return operations;
    }
}