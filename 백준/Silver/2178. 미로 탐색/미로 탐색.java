import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N;
    private static int M;

    static class Pointer {
        int nx, ny;

        public Pointer(int nx, int ny) {
            this.nx = nx;
            this.ny = ny;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        bw.write(String.valueOf(map[N - 1][M - 1]));
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;

        ArrayDeque<Pointer> queue = new ArrayDeque<>();
        queue.add(new Pointer(x, y));

        while (!queue.isEmpty()) {
            Pointer now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.nx + dx[i];
                int nextY = now.ny + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }

                map[nextX][nextY] = map[now.nx][now.ny] + 1;
                queue.add(new Pointer(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
    }
}
