/**
m x n 정수 행렬 격자와 크기 k의 queries가 주어집니다.
각 정수 queries[i]에 대해 행렬의 왼쪽 위 셀에서 시작하여 다음 과정을 반복하는 크기 k의 배열 답을 구합니다:
queries[i]가 현재 있는 셀의 값보다 엄격하게 크면, 이 셀을 처음 방문하는 경우 1점을 얻고 상하좌우 4방향 모두에서 인접한 셀로 이동할 수 있습니다.
그렇지 않으면 점수를 얻지 못하고 이 과정을 종료합니다.
이 과정이 끝나면 answer[i]가 획득할 수 있는 최대 점수입니다. 각 쿼리에 대해 동일한 셀을 여러 번 방문할 수 있습니다.
결과 배열 답을 반환
 */
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int k = queries.length;
        int[] answer = new int[k];
        
        int[][] sortedQueries = new int[k][2];
        for (int i = 0; i < k; i++) {
            sortedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int points = 0;
        int prevQuery = 0;

        for (int[] queryPair : sortedQueries) {
            int query = queryPair[0], idx = queryPair[1];

            while (!pq.isEmpty() && pq.peek()[0] < query) {
                int[] cell = pq.poll();
                int value = cell[0], x = cell[1], y = cell[2];

                points++; 

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                        pq.offer(new int[]{grid[newX][newY], newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            answer[idx] = points;
        }

        return answer;
    }
}