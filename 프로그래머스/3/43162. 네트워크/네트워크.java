/*
문제파악
- A-B, B-C 라면 A-C도 간접 연결
- 컴퓨터 개수 n, 연걸에 대한 정보가 담긴 2차원 배열 computers, 네트워크 개수를 return

- i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j] 를 1로 표현

- 최적의 해를 구하는 것이 아닌 모든 경우의 수를 파악 -> 깊이 우선 탐색
- 
*/

import java.util.*;

class Solution {
    private static boolean[] visit;
    private static int[][] computer;
    
    private static void dfs(int now) {
        visit[now] = true;
        
        for (int i = 0; i < computer[now].length; i++) {
            if (!visit[i] && computer[now][i] == 1) {
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        computer = computers;
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) { // 방문하지 않았다면
                dfs(i);
                answer++; // DFS로 연결된 노드들을 모두 방문하면서 네트워크 개수 증가
            }
        }
        
        return answer;
    }
}