/**
패턴이..
1 -> 1
2 -> 5
3 -> 13
-> n^2 + (n-1)^2 
 */

class Solution {
    public long coloredCells(int n) {
        return 1L + 2L * (n - 1) * n;
    }
}