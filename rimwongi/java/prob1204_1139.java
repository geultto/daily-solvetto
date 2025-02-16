/**
정수 n이 주어졌을 때, 다음을 모두 만족하는 수열을 구합니다: 
    정수 1은 수열에서 한 번 나타난다.
    2와 n 사이의 각 정수는 수열에서 두 번 나타난다.
    2와 n 사이의 모든 정수 i에 대해, i의 두 발생 사이의 거리는 정확히 i입니다. 
    
    수열의 두 수, a[i]와 a[j] 사이의 거리는 그 인덱스의 절대 차이인 |j - i|입니다. 
    사전적으로 가장 큰 수열을 반환합니다. 
    주어진 제약 조건 하에서 항상 해가 있다는 것이 보장됩니다. 
    수열 a와 수열 b가 다른 첫 번째 위치에서 수열 a가 수열 b의 해당 수보다 큰 수를 갖는다면 수열 a는 (같은 길이의) 수열 b보다 사전적으로 큰 것입니다. 
        예를 들어 [0,1,9,0]은 [0,1,5,6]보다 사전적으로 큰데, 왜냐하면 이들이 다른 첫 번째 위치가 세 번째 수이고 9는 5보다 크기 때문
 */
class Solution {
    public int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;
        int[] result = new int[len];
        boolean[] used = new boolean[n + 1];
        
        dfs(result, used, 0, n);
        return result;
    }

    private boolean dfs(int[] result, boolean[] used, int index, int n) {
        if (index == result.length) {
            return true;
        }
        if (result[index] != 0) {
            return dfs(result, used, index + 1, n);
        }

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;
            if (num == 1) { 
                result[index] = 1;
                used[1] = true;
                if (dfs(result, used, index + 1, n)) {
                    return true;
                }
                result[index] = 0;
                used[1] = false;
            } else {
                int secondIndex = index + num;
                if (secondIndex < result.length && result[secondIndex] == 0) {
                    result[index] = result[secondIndex] = num;
                    used[num] = true;
                    
                    if (dfs(result, used, index + 1, n)) {
                        return true;
                    }
                    
                    result[index] = result[secondIndex] = 0;
                    used[num] = false;
                }
            }
        }
        return false;
    }
}