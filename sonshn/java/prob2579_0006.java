class Solution {
    public long coloredCells(int n) {
        return (long) Math.pow(n, 2) + (long) Math.pow(n-1, 2);
    }
}