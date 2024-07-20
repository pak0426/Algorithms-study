/*
문제 파악
- 1명 선수는 제외하고 모든 선수가 마라톤을 완주
- 마라톤 참여 선수 배열 participant, 완주한 선수 배열 completion
- 완주하지 못한 선수의 이름을 return

- 선수 1 이상 100,000 이하 (시간 복잡도를 고려해야함)
- completion의 길이 = participant의 길이 - 1
- 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자
- **참가자 중에 동명이인이 있을 수 있다.**
*/

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> pMap = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            
            if (pMap.containsKey(participant[i])) {
                int count = pMap.get(participant[i]);
                pMap.put(participant[i], ++count);
            }
            else {
                pMap.put(participant[i], 1);
            }            
        }
        
        
        for (int i = 0; i < completion.length; i++) {
            String complete = completion[i];
            if (pMap.containsKey(complete)) {
                
                int count = pMap.get(complete);
                if (count == 1) {
                    pMap.remove(complete);
                }
                else {
                    pMap.put(complete, --count);
                }
            }
        }
        
        return pMap.keySet().iterator().next();
    }
}