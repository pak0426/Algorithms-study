import java.util.*;

class Solution {
    private static List<Integer> list;
    private static int[][] Dungeons;
    private static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        Dungeons = dungeons;
        visited = new boolean[dungeons.length];
        list = new ArrayList<>();
        
        backtrack(k, 0);
        return Collections.max(list);
    }
    
    private static void backtrack(int k, int count) {
        list.add(count);
        
        for (int i = 0; i < Dungeons.length; i++) {
            if (!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;
                backtrack(k - Dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}