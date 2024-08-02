/*
문제파악
- 루트 노드에서 출발하여 각 노드를 돌아다니며 양을 모은다.
- 각 노드를 방문할 때 마다 해당 녿에 있던 양과 늑대가 나를 따라옴
- 이때 늑내는 양을 잡아먹을 기회를 노리며, 내가 모은 양의 수보다 늑대의 수가 같거나 더 많으면 (<=) 모든 양을 잡아먹힌다.
- 나는 중간에 양이 늑대에게 잡아먹히지 않도록 최대한 많은 수의 양을 모아서 루트 노드로 돌아와야함

- 루트노드엔 항상 양이 있다.
- 각 노드에 있는 양 또는 늑대에 대한 정보 info
- 2진 트리 각 노드들의 연결 관계를 담은 2차원 배열 edges
- 주어진 조건에 따라 모을 수 있는 양은 최대 몇 마리인지 return

[0,0,1,1,1,0,1,0,1,0,1,1]	
[[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]
*/

import java.util.*;

class Solution {
    
    private static class Info {
        int node;
        int sheep;
        int wolf;
        HashSet<Integer> visited;
        
        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }
    
    private static ArrayList<Integer>[] tree;
    
    private void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        buildTree(info, edges);
        
        int answer = 0;
        
        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));
        
        // BFS(너비 우선 탐색) 시작
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            answer = Math.max(answer, now.sheep);
            
            // 방문한 노드 집합에 현재 노드의 이웃 노드 추가
            now.visited.addAll(tree[now.node]);
            
            for (int next : now.visited) {
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);
                
                if (info[next] == 1) { // 늑대일때
                    if (now.sheep != now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                }
                else {
                    queue.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
        }
        
        return answer;
    }
}