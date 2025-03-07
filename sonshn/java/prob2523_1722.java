class Solution {
    private static boolean isPrime(int num) {
        if(num == 1) return false;
        if(num == 2) return true;
    
        if(num % 2 == 0) return false;

        for(int i=3; i*i<=num; i+=2) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static int[] findPrimes(int left, int right) {
        int[] answer = new int[]{-1, -1};
        int previousPrime = -1;
        int minimum = Integer.MAX_VALUE;

        for (int num = left; num <= right; num++) {
            if (isPrime(num)) {
                if (previousPrime != -1) {
                    int diff = num - previousPrime;

                    if (diff < minimum) {
                        minimum = diff;
                        answer[0] = previousPrime;
                        answer[1] = num;
                    }
                }
                previousPrime = num;
            }
        }

        return answer[1] != -1 ? answer : new int[]{-1, -1};
    }

    public int[] closestPrimes(int left, int right) {
        return findPrimes(left, right);
    }
}