class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int size = grid[0].length;
        int[] memo = new int[size*size + 1];
        int[] answer = new int[2];

        for(int row=0; row<size; row++) {
            for(int column=0; column<size; column++) {
                memo[grid[row][column]]++;
            }
        }

        for(int i=1; i<memo.length; i++) {
            if(memo[i] == 2) {
                answer[0] = i;
            }

            if(memo[i] == 0) {
                answer[1] = i;
            }
        }

        return answer;
    }
}