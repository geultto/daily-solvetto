import java.util.*;

class Solution {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    
    static class Node {
        private int index;
        private int distance;
        
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        
        public int getIndex() {
            return this.index;
        }
        
        public int getDistance() {
            return this.distance;
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    
        boolean[] visited = new boolean[n+1];
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> distances = new PriorityQueue<>(Collections.reverseOrder());
        int maxDistance = -1;
        
        visited[1] = true;
        q.add(new Node(1, 0));
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            distances.add(node.getDistance());
            
            maxDistance = Math.max(maxDistance, node.getDistance());
            
            for (Integer next : graph.get(node.getIndex())) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(new Node(next, node.getDistance()+1));
            }
        }
    
        for (Integer distance : distances) {
            if (distance == maxDistance) {
                ++answer;
            }
        }
        
        return answer;
    }
}