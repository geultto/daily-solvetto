/**
nums에는 서로 다른 '양의 정수'가 포함
여기서 a, b, c, d라는 순서가 있는 4개의 수를 찾아야함
이 때 a * b = c * d면서 각각 서로 달라야함

-> 완전 탐색은 X 대충 1억개의 연산이 예상됨 O(n)
-> 그렇다면 Hashmap 사용?
곱셈 결과를 만드는 a,b 쌍의 갯수 
ex) map[x] = k라면 k개의 (a, b) 쌍 중 2개를 선택하는 방법 k * (k-1)
 */

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];

                if (map.containsKey(product)) {
                    int pairCount = map.get(product);
                    count += pairCount * 8;
                }

                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        return count;
    }
}