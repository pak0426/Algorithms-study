import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int[][] maps;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 초기값
        String str = br.readLine();
        N = Integer.parseInt(str);
        maps = new int[N][N];
        visited = new boolean[N][N];

        // 지도 초기화
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                maps[i][j] = s.charAt(j) - '0';
            }
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    results.add(count);
                }
            }
        }

        Collections.sort(results);

        StringBuilder sb = new StringBuilder();
        sb.append(results.size() + "\n");
        for (int i = 0; i < results.size(); i++) {
            String s = i != results.size() - 1 ? "\n" : "";
            sb.append(results.get(i) + s);
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

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || maps[nx][ny] != 1) {
                continue;
            }

            count++;
            dfs(nx, ny);
        }
    }
}
