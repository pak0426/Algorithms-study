import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited = new boolean[101][101];
    static int[][] map = new int[101][101];
    static int row, col;
    static int cnt = 0;

    public int dfs(int x, int y) {
        visited[x][y] = true;
        cnt += map[x][y];

        for (int i = 0; i < 4; i++) {
            if (x + dx[i] < 0 || x + dx[i] >= row || y + dy[i] < 0 || y + dy[i] >= col)
                continue;
            if (map[x + dx[i]][y + dy[i]] >= 0 && visited[x + dx[i]][y + dy[i]] == false)
                dfs(x + dx[i], y + dy[i]);
        }
        return cnt;
    }

    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        row = maps.length;
        col = maps[0].length();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].substring(j, j + 1).equals("X"))
                    map[i][j] = -1;
                else
                    map[i][j] = Integer.parseInt(maps[i].substring(j, j + 1));
            }
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] > 0 && visited[i][j] == false) {
                    answer.add(dfs(i, j));
                    cnt = 0;
                }
            }
        }
        if (answer.size() < 1) {
            answer.add(-1);
            return answer.stream().mapToInt(i -> i).toArray();
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }

}