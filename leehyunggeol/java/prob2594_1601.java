import java.util.*;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long)Arrays.stream(ranks).min().getAsInt() * cars * cars;
        
        while (left < right) {
            long mid = (left + right) / 2;

            if (canAllCarsBeFixed(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canAllCarsBeFixed(int[] ranks, int cars, long minutes) {
        long totalFixedCars = 0;

        for (int rank : ranks) {
            totalFixedCars += Math.sqrt(minutes / rank);
        }

        return totalFixedCars >= cars;
    }
}