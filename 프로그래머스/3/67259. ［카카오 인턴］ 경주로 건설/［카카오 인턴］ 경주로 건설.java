import java.util.*;

class Solution {
    private static class Node {
        int x, y, direction, cost;
        
        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    
    private static final int[] rx = {0, -1, 0, 1};
    private static final int[] ry = {-1, 0, 1, 0};
    private static int N;
    private static int[][][] visited;
    
    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
    
    private static boolean isBlocked(int[][] board, int x, int y) {
        return (x == 0 && y == 0) || !isValid(x, y) || board[x][y] == 1;
    }
    
    private static int calculateCost(int direction, int preDirection, int cost) {
        if (preDirection == -1 || (preDirection - direction) % 2 == 0) {
            return cost + 100;
        }
        return cost + 600;
    }
    
    private static boolean isShouldUpdate(int x, int y, int direction, int newCost) {
        return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;
    }
    
    public int solution(int[][] board) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, -1, 0));
        N = board.length;
        visited = new int[N][N][4];
        
        int answer = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int new_x = now.x + rx[i];
                int new_y = now.y + ry[i];
                
                if (isBlocked(board, new_x, new_y)) {
                    continue;
                }
                
                int new_cost = calculateCost(i, now.direction, now.cost);
                
                if (new_x == N - 1 && new_y == N - 1) {
                    answer = Math.min(answer, new_cost);
                }
                else if (isShouldUpdate(new_x, new_y, i, new_cost)) {
                    queue.add(new Node(new_x, new_y, i, new_cost));
                    visited[new_x][new_y][i] = new_cost;
                }
            }
        }
        
        return answer;
    }
}