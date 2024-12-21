class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int[] p1 = new int[sequence.length];
        int[] p2 = new int[sequence.length];
        boolean isPlus = true;
        
        for (int i = 0; i < sequence.length; ++i) {
            p1[i] = isPlus ? sequence[i] : -sequence[i];
            p2[i] = isPlus ? -sequence[i] : sequence[i];
            isPlus = !isPlus;
        }
        
        long max1 = 0, max2 = 0;
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        dp1[0] = p1[0];
        dp2[0] = p2[0];
        answer = Math.max(answer, Math.max(dp1[0], dp2[0]));
        
        for (int i = 1; i < sequence.length; ++i) {
            dp1[i] = Math.max(dp1[i-1] + p1[i], p1[i]);
            dp2[i] = Math.max(dp2[i-1] + p2[i], p2[i]);
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }
        
        return answer;
    }
}