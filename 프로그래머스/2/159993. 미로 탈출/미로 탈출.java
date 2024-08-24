/*
문제파악
- 최소 시간, 최단 경로라는 키워드 -> 너비 우선 탐색, 최소 경로 알고리즘, 다익스트라 알고리즘
- 하지만 가중치가 있는 간선이 없고, 너비 우선 탐색은 최단 경로를 보장함.
*/

import java.util.*;

class Solution {
    
    // 위, 아래, 왼쪽, 오른쪽
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    private static class Point {
        private int nx;
        private int ny;
        
        public Point(int nx, int ny) {
            this.nx = nx;
            this.ny = ny;
        }
    }
    
    private static char[][] map;
    private static int N, M;
    
    
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        // 미로에 대한 정보를 배열로 저장
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
        }

        Point start = null, end = null, lever = null;

        // 시작 지점, 출구 그리고 레버의 위치를 찾음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') start = new Point(j, i);
                else if (map[i][j] == 'E') end = new Point(j, i);
                else if (map[i][j] == 'L') lever = new Point(j, i);
            }
        }

        // 시작 자점 -> 레버, 레버 -> 출구까지의 최단 거리를 각각 구함
        int startLever = bfs(start, lever);
        int leverEnd = bfs(lever, end);

        // 도착 불가능한 경우는 -1, 도착 가능한 경우는 최단 거리를 반환
        if (startLever == -1 || leverEnd == -1)
            return -1;
        else
            return startLever + leverEnd;
    }

    // start -> end 로 너비 우선 탐색하여 최단거리 반환
    private static int bfs(Point start, Point end) {
        // 너비 우선 탐색 초기 과정
        int[][] dist = new int[N][M];
        ArrayDeque<Point> queue = new ArrayDeque<>();

        dist[start.ny][start.nx] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            // 네 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nextX = now.nx + dx[i];
                int nextY = now.ny + dy[i];

                // 범위를 벗어나는 경우 예외 처리
                if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
                    continue;

                // 이미 방문한 지점인 경우 탐색하지 않음
                if (dist[nextY][nextX] > 0)
                    continue;

                // X가 아닌 지점만 이동 가능
                if (map[nextY][nextX] == 'X')
                    continue;

                // 거리 1증가
                dist[nextY][nextX] = dist[now.ny][now.nx] + 1;

                // 다음 정점을 큐에 넣음
                queue.add(new Point(nextX, nextY));

                // 도착점에 도달하면 최단 거리를 반환
                if (nextX == end.nx && nextY == end.ny)
                    return dist[end.ny][end.nx] - 1;
            }
        }

        // ⓯ 탐색을 종료할 때까지 도착 지점에 도달하지 못 했다면 -1 반환
        return -1;
    }
}