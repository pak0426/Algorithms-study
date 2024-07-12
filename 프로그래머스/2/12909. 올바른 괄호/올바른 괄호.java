/*
문제 파악
- '('로 열렸다면 ')'로 닫혀야함.
- 이걸 판별하는 함수를 만들어라
*/

import java.util.*;

class Solution {
    boolean solution(String s) {
        // 스택을 선언
        Stack<Character> stack = new Stack<>();
        
        // s를 Character로 반복문
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));    
            }
            else {
                try {
                    stack.pop();    
                } 
                catch (EmptyStackException e) {
                    return false;    
                }
                
            }
        }
        
        if (stack.size() > 0) {
            return false;
        }
        
        return true;
    }
}