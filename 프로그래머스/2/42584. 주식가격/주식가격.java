/*
문제파악
- 주식가격이 담긴 배열 prices
- 가격이 떨어지지 않은 기간은 몇 초인지 return
- 1 이상 10,000 이하의 자연수, 길이는 2 이상 100,000 이하
  - 시간 복잡도를 고려해야함.
*/
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        
        stack.push(0);
        for (int i = 1; i < prices.length; i++) {
            
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }
        
        return answer;
    }
}