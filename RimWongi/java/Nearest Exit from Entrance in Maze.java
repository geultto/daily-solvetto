public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], steps = current[2];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n 
                        && maze[newRow][newCol] == '.') {
                    if (newRow == 0 || newRow == m - 1 || newCol == 0 || newCol == n - 1) {
                        return steps + 1;
                    }
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                    maze[newRow][newCol] = '+'; 
                }
            }
        }
        return -1; 
    }
}