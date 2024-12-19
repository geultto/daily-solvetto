class Solution {
    /** pseudo code
    int start, end index 설정
    start가 end가 될 때까지 반복
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
            count++;
        }
        if (count >= n) {
            return true;
        }
    }
    return false;
    }
}