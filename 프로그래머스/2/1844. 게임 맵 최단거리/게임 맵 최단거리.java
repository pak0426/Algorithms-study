/*
문제 파악
- ROR 게임은 두 팀으로 나누어서 진행하며, 상태 팀 진영을 먼저 파괴하면 이기는 게임이다. 
- 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리하다.

- 지나가는 칸의 최솟값을 구해야함.
- 최적값, 최솟값을 구하는건 너비 우선 탐색이다. (BFS)

*/

import java.util.*;

class Solution {
    
    // 이동할 수 있는 방향을 나타내는 배열
    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};
    
    private static class Node {
        int r; // row
        int c; // cell
        
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] maps) {
        
        int N = maps.length;
        int M = maps[0].length;
        
        // 최단 거리를 저장
        int[][] distance = new int[N][M];
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        queue.addLast(new Node(0, 0));
        distance[0][0] = 1;
        
        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();
            
            // now에서 이동할 수 있는 방향
            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];
                
                // 맵 밖으로 나가는 경우 예외처리
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }
                
                // 방해물 벽으로 가는 경우 예외처리
                if (maps[nr][nc] == 0) {
                    continue;
                }
                
                // 이동한 위치가 처음 방문이라면, queue에 추가하고 거리 갱신
                if (distance[nr][nc] == 0) {
                    queue.addLast(new Node(nr, nc));
                    distance[nr][nc] = distance[now.r][now.c] + 1;
                }
            }
        }
        
        return distance[N - 1][M - 1] == 0 ? -1 : distance[N - 1][M - 1];
    }
    
    
}