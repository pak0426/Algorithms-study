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
        int answer = 0;
        
        Map<String, HashSet<String>> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i ++) {
            HashSet<String> list;
            String category = clothes[i][1];
            String wear = clothes[i][0];
            
            if (map.containsKey(category)) {
                list = map.get(category);
            } 
            else {
                list = new HashSet<>();
            }
            list.add(wear);
            map.put(category, list);
        }
        
        List<Integer> list = new ArrayList<>();
        map.entrySet().stream()
                .forEach(m -> list.add(m.getValue().size()));


        int multiple = 1;
        for (int i = 0; i < list.size(); i++) {
            multiple *= list.get(i) + 1;
        }
        
        return multiple - 1;
    }
}