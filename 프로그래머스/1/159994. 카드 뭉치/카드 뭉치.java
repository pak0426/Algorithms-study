/*
문제 파악
- 카드 뭉치 2개
- 원하는 순서의 단어 배열을 만듬

- Goal 배열의 모양을 만들 수 있다면 Yes, 아니면 No
*/
import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        
        ArrayDeque<String> deque1 = new ArrayDeque<>();
        ArrayDeque<String> deque2 = new ArrayDeque<>();

        for (int i = 0; i < cards1.length; i++) {
            deque1.addLast(cards1[i]);
        }
        
        for (int i = 0; i < cards2.length; i++) {
            deque2.addLast(cards2[i]);
        }
        
        int count = 0;
        List<String> list = new ArrayList<>();
        A:for (int i = 0; i < goal.length; i++) {
            String word = goal[i];
            
            for (int j = 0; j < deque1.size(); j++) {
                if (word.equals(deque1.peekFirst())) {
                    count++;
                    list.add(deque1.pollFirst());
                    continue A;
                }
            }
            
            for (int j = 0; j < deque2.size(); j++) {
                if (word.equals(deque2.peekFirst())) {
                    count++;
                    list.add(deque2.pollFirst());
                    continue A;
                }
            }
        }
        
        if (count == goal.length) {
            answer = "Yes";
        }
        
        return answer;
    }
}