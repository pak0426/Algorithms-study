/*
문제 파악
- [], (), {} 등의 올바른 괄호 문자열이면 (([])) 등도 올바른 문자열이다.
  - Stack을 이용해 열림 문자를 판단하고 닫힘 문자가 있으면 pop();
- [], (), {} 로만 이루어짐
- 왼쪽으로 x만큼 문자열을 밀었을 때 올바른 괄호 문자열의 개수를 구해야한다.
- 1,000 이상의 길이이므로 시간복잡도 생각 x
*/

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            deque.addLast(c);
        }
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            Character[] chars = deque.toArray(new Character[0]);
            
            for (Character c : chars) {
                if (!map.containsKey(c)) {
                    stack.push(c);
                }
                else {
                    if (!stack.isEmpty() && map.get(c).equals(stack.peek())) {
                         stack.pop();
                    }
                    else {
                        answer--;
                        break;
                    }
                }
            }
            
            if (stack.size() == 0) answer++;
            
            deque.addLast(deque.removeFirst());
        }
        
        if (answer <= 0) answer = 0;
        return answer;
    }
}