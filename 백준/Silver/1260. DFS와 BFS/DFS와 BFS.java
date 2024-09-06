import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String[] arr = str.split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        int V = Integer.parseInt(arr[2]);

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine();
            arr = str.split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (List<Integer> list : graph) {
            Collections.sort(list);
        }

        dfs(V);
        sb.append("\n");
        bw.write(sb.toString());

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        bfs(V);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");

        for (int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now + " ");

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}