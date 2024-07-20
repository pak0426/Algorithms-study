/*
문제 파악
- 카드 뭉치 2개
- 원하는 순서의 단어 배열을 만듬

- Goal 배열의 모양을 만들 수 있다면 Yes, 아니면 No
*/
import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));
        
        while (!goalDeque.isEmpty()) {
            if (!cardsDeque1.isEmpty() && cardsDeque1.peekFirst().equals(goalDeque.peekFirst())) {
                cardsDeque1.pollFirst();
                goalDeque.pollFirst();
            }
            else if (!cardsDeque2.isEmpty() && cardsDeque2.peekFirst().equals(goalDeque.peekFirst())) {
                cardsDeque2.pollFirst();
                goalDeque.pollFirst();   
            }
            else {
                break;
            }
        }
        
        return goalDeque.isEmpty() ? "Yes" : "No";
    }
}