import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static int testCase, N, M, K, result;
    private static int[][] maps;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0 ,0};
    private static int[] dy = {0 ,0, -1, 1};

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
        StringBuilder sb = new StringBuilder();

        testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 초기화
            maps = new int[N][M];
            visited = new boolean[N][M];

            // 지도 초기화
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                maps[x][y] = 1;
            }

            // 찾기 시작
            result = 0;
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < M; b++) {
                    if (maps[a][b] == 1 && !visited[a][b]) {
//                        dfs(a, b);
                        bfs(a, b);
                        result++;
                    }
                }
            }

            String s = i == testCase - 1 ? "" : "\n";
            sb.append(result + s);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || maps[nx][ny] == 0) {
                continue;
            }

            dfs(nx, ny);
        }
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

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visited[nextX][nextY] || maps[nextX][nextY] == 0) {
                    continue;
                }

                queue.add(new Pointer(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
    }
}
