class Solution {
    /**
    현재 최저점(0번 인덱스)에서 시작
    최대 이익을 갱신하도록 한다.
    prices를 순회
     */
    public int maxProfit(int[] prices) {
        
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price-minPrice);
        }
        return maxProfit;
    }
}