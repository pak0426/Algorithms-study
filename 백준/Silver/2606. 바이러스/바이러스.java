import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 초기화
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 그리기
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(1);

        int result = -1;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                result++;
            }
        }
        
        if (result == -1) result = 0;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void dfs(int start){
        visited[start] = true;

        for (int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}