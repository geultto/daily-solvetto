import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        Queue<ClosestPrimeNumberPair> pq = new PriorityQueue<>();

        int num1 = 0, num2 = 0, count = 0;
        for (int n = left; n <= right; ++n) {
            if (isPrime(n)) {
               if (count == 0) {
                    num1 = n;
                    count++;
                } else {
                    num2 = n;
                    if (num2 - num1 == 1 || num2 - num1 == 1) {
                        return new int[]{num1, num2};
                    }
                    pq.add(new ClosestPrimeNumberPair(num2-num1, num1, num2));
                    num1 = num2;
                }
            }
        }

        int[] answer = new int[2];
        if (!pq.isEmpty()) {
            answer = pq.peek().getPair();
        }

        if (answer[0] == 0 || answer[1] == 0) {
            answer = new int[]{-1,-1};
        }

        return answer;
    }

    // n이 소수이면 true, 아니면 false를 반환하는 메서드
    private boolean isPrime(int n) {
        if(n < 2) { // 2보다 작은 수는 소수가 아님
            return false;
        }
        // 2부터 sqrt(n)까지 나누어 떨어지는지 검사
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false; // 약수가 있으면 소수가 아님
            }
        }
        return true;
    }

    static class ClosestPrimeNumberPair implements Comparable<ClosestPrimeNumberPair> {
        int diff, num1, num2;

        public ClosestPrimeNumberPair(int diff, int num1, int num2) {
            this.diff = diff;
            this.num1 = num1;
            this.num2 = num2;
        }

        public int[] getPair() {
            return new int[]{num1, num2};
        } 

        @Override
        public int compareTo(ClosestPrimeNumberPair other) {
            if (this.diff == other.diff) {
                return this.num1 - other.num1;
            }
            return this.diff - other.diff;
        }
    }
}