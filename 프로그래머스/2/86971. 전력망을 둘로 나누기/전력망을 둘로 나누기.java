import java.util.*;

class Solution {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int N, answer;
    
    public int solution(int n, int[][] wires) {
        N = n;
        answer = n - 1;
        graph = new ArrayList<>(n + 1);
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        
        for (int i = 0; i < wires.length; i++) {
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        dfs(1);
        return answer;
    }
    
    private static int dfs(int start) {
        visited[start] = true;
        
        
        int sum = 0;
        for (int next : graph.get(start)) {
            if (!visited[next]) {
                int cnt = dfs(next);
                answer = Math.min(answer, Math.abs(N - cnt * 2));
                sum += cnt;
            }
        }
        
        return sum + 1;
    }
}