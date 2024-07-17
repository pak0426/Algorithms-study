/*
문제 파악
- n*n 으로 이루어진 상자에 바구니로 인형을 옮김
- 같은 인형이 연속적으로 발생하면 바구니에서 사라진다.
- 인형이 없는 곳을 향해 크레인을 작동 시키는 경우가 있음
- 바구니는 모든 인형이 들어갈 수 있음
- 격자 상태가 담긴 2차원 배열 board, 크레인을 작동시킨 위치가 담긴 배열 moves, 크레인 작동 후 터트려져 사라진 인형의 개수를 return 하는 함수 완성

- board는 2차원 배열 5*5 이상 30*30 이하
  - board를 n^2으로 시간복잡도를 설정해도 된다.
- board에 담긴 100이하의 정수는 인형의 모양을 의미한다.

- 사라진 인형의 개수를 구해야한다.
*/
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        A:for (int i = 0; i < moves.length; i++) {
            int xAxis = moves[i] - 1;
            
            for (int j = 0; j < board.length; j++) {
                int picked = board[j][xAxis];
                if (picked > 0) {
                    
                    if (!stack.isEmpty() && stack.peek() == picked) {
                        stack.pop();
                        answer++;
                    }
                    else {
                        stack.push(picked);
                    }
                    board[j][xAxis] = 0;
                    continue A;
                }
            }
        }    
        
        return answer * 2;
    }
}

/*
[0, 0, 0, 0, 0]
[0, 0, 1, 0, 3]
[0, 2, 5, 0, 1]
[4, 2, 4, 4, 2]
[3, 5, 1, 3, 1]
*/