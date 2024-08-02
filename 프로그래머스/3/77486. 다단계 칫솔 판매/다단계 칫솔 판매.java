/*
문제파악
- 칫솔을 판매하면 그 이익이 피라미드 조직을 타고 분배되는 형태
- 판매에 발생하는 이익의 10%를 자신을 참여시킨 추천인에게 배분

- enroll: 판매원의 이름을 담은 배열
- referral: 각 판매원을 조직에 참여시킨 다른 판매원의 이름을 담은 배열
- seller: 판매량 집계 데이터의 판매원 이름을 나열
- amount: 판매량 집계 데이터의 판매 수량 나열

- 칫솔 판매금액은 100원으로 정해져 있다.
- 각 판매원이 득한 이익금을 나열한 배열을 return
*/

import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 추천자를 담을 map
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], referral[i]);
        }
        // 여기서 while문을 돌리면서 가격을 입력
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int money = amount[i] * 100;
            
            while (money > 0 && !name.equals("-")) {
                result.put(name, result.getOrDefault(name, 0) + money - (money / 10));
                name = map.get(name);
                money /= 10;
            }
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            answer[i] = result.getOrDefault(name, 0);
        }
        
        return answer;
    }
}