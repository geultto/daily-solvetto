class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length;

        // 전체 쿼리를 적용해도 배열을 0으로 만들 수 없으면 -1 반환
        if (!zero(nums, queries, queries.length)) {
            return -1;
        }

        // 이분 탐색: 최소 몇 개의 쿼리만 적용했을 때 배열이 0이 되는지 찾음
        while (left <= right) {
            int mid = (left + right) / 2;
            if (zero(nums, queries, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean zero(int[] nums, int[][] queries, int queryLength) {
        int sum = 0;
        int[] prefixSum = new int[nums.length + 1];

        // 첫 queryLength개의 쿼리를 적용하여, 
        // 각 쿼리는 범위 [l, r]에 val만큼의 변화를 줌.
        // 차분 배열(difference array) 기법을 사용하여 적용 효과를 누적합니다.
        for (int i = 0; i < queryLength; ++i) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            prefixSum[l] += val;
            prefixSum[r + 1] -= val;
        }

        // 누적합(prefix sum)을 계산하여 각 인덱스에 적용된 총 효과를 구합니다.
        // 여기서 sum은 인덱스 0부터 현재 인덱스까지의 쿼리 효과의 합입니다.
        for (int i = 0; i < nums.length; ++i) {
            sum += prefixSum[i];
            // 만약 이 누적 효과가 원래의 값보다 작으면,
            // 즉, 쿼리들의 효과가 해당 위치의 nums[i]를 0 이하로 만들기에 충분하지 않으면 false 반환
            if (sum < nums[i]) {
                return false;
            }
        }

        return true;
    }
}