/*
문제 파악하기
- 소문자 알파벳 문자열, 같은 알파벳 2개가 붙어 있는 짝을 찾는다.
- 그 둘을 제거 후, 앞뒤로 문자열을 이어 붙인다. (이 과정을 반복 수행)
- 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성하자

- 문자열의 길이: 100만이하의 자연수
  - 따라서 이 중 반복문을 사용하면 n^2 의 시간복잡도를 가짐 (시간 초과 발생)
*/
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek().equals(c)) {
                 stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        
        if (stack.size() == 0) return 1;
        else return 0;
    }
}