/*
문제 파악
- 매일 다른 옷을 조합
- 종류별로 최대 1가지 의상만 착용
- 의상이 일부가 겹쳐도, 다른 의상이 겹치지 않거나, 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 착용한 것으로 계산
- 코니는 하루에 최소 1개의 의상을 입는다.

- 코니가 가진 의상들이 담긴 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return
*/

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        int answer = 1;
        for (Integer value : map.values()) {
            answer *= value + 1;
        }
        
        return answer - 1;
    }
}