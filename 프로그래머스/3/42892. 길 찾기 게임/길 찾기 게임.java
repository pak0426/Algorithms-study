/*
문제파악
- 2팀으로 나누고, 각 팀이 같은 곳을 다른 순서로 방문해서 먼저 순회를 마친 팀이 승리
- 방문할 곳의 2차원 좌표 값을 구하고 각 장소를 이진 트리의 노드가 되도록 구성한 후,
- 순회 방법을 힌트로 주어 각 팀이 스스로 경로를 찾음

- 노드들의 좌표가 담길 배열 nodeinfo가 매개변수
- 노드들로 구성된 이진트리를 전위, 후위 순회한 결과를 2차원 배열에 순서대로 담아 return

1. 이진 트리를 구축
2. 간선을 연결
3. 재귀를 통해 자식을 찾아준다
4. 정렬한다. y축 작은거부터, x축 작은거부터

*/

import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        
        Node root = makeTree(nodeinfo);
        ArrayList<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList);
        ArrayList<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList);
        
        answer = new int[2][preOrderList.size()];
        
        
        for (int i = 0; i < preOrderList.size(); i++) {
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }
        
        
        return answer;
    }
    
    public static class Node {
        int num;
        int x;
        int y;
        Node left;
        Node right;
            
        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    // 이진트리 생성 메서드
    public static Node makeTree(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) {
               return Integer.compare(o1.x, o2.x);
            }
            return Integer.compare(o2.y, o1.y);
        });
        
        Node root = nodes[0];
        
        for (int i = 1; i < nodes.length; i++) {
            Node parent = root;
            
            while (true) {
                if (nodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    }
                    else {
                        parent = parent.left;
                    }
                }
                else {
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    }
                    else {
                        parent = parent.right;
                    }
                }
            }
        }
        
        return nodes[0];
    }
    
    private static void preOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }
    
    private static void postOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }
}







