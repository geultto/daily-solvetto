class Solution {
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Edge cases
        if (m == 1 || n == 1) {
            return 0;
        }
        // 1. Check rows
        int rowFlips = countRowFlips(grid, m, n);

        // 2. Check columns
        int colFlips = countColumnFlips(grid, m, n);

        // 3. Return minimum
        return Math.min(rowFlips, colFlips);
    }

    private int countRowFlips(int[][] grid, int m, int n) {
        int totalFlips = 0;
        for (int i = 0; i < m; i++) {
            totalFlips += countFlips(grid[i]);
        }
        return totalFlips;
    }

    private int countColumnFlips(int[][] grid, int m, int n) {
        int totalFlips = 0;
        // 각 column에 대해
        for (int j = 0; j < n; j++) {
            // 해당 column의 값들을 임시 배열에 저장
            int[] colArray = new int[m];
            for (int i = 0; i < m; i++) {
                colArray[i] = grid[i][j];
            }
            // palindrome check
            totalFlips += countFlips(colArray);
        }
        return totalFlips;
    }

    private int countFlips(int[] arr) {
        int left = 0, right = arr.length - 1;
        int flips = 0;

        while (left < right) {
            if (arr[left] != arr[right]) {
                flips++;
            }
            left++;
            right--;
        }
        return flips;
    }
}