import java.util.*;

class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 0, right = Arrays.stream(candies).max().getAsInt();
        
        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (canDivideToChildren(candies, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canDivideToChildren(int[] candies, int mid, long k) {
        long sum = 0;

        for (int candy : candies) {
            sum += (long)(candy / mid); 
            if (sum >= k) {
                return true;
            }
        }

        return false;
    }
}