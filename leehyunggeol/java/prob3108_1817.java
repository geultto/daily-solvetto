class Solution {
    private static int[] parent;
    private static int[] minPathCost;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        minPathCost = new int[n];

        Arrays.fill(minPathCost, -1);

        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int startRoot = find(u);
            int endRoot = find(v);

            minPathCost[endRoot] &= w;

            if (startRoot != endRoot) {
                minPathCost[endRoot] &= minPathCost[startRoot];
                parent[startRoot] = endRoot; 
            }
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; ++i) {
            int s = query[i][0];
            int e = query[i][1];

            if (s == e) {
                answer[i] = 0;
            } else if (find(s) != find(e)) {
                answer[i] = -1;
            } else {
                answer[i] = minPathCost[find(s)];
            }
        }

        return answer;
    }

    private int find(int n) {
        if (parent[n] != n) {
            return parent[n] = find(parent[n]);
        }
        return parent[n];
    }
}