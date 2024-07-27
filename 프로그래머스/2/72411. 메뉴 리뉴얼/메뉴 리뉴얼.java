/*
문제 파악
- 단품 메뉴에서 코스요리 형태로 구성
- 어떤 단품 메뉴들을 조합해서 코스 메뉴로 구성하면 좋을지 고민, 이전 각 손님들이 주문할 때 많이 주문한 단품 메뉴들을 구성하기로 함

- 단, 코스요리 메뉴는 최소 2가지 이상의 단품 메뉴로 구성
- 최소 2명 이상의 손님으로부터 주문된 단품 메뉴 조합에 대해서만 코스요리 메뉴 후보에 포=]\

- 손님들이 주문한 단품메뉴 orders
- 코스요리를 구성하는 단품 메뉴들의 개수가 담긴 배열 cource
- 새로 추가하게 될 코스요리의 메뉴 구성을 return
*/

import java.util.*;

class Solution {
    private static Map<Integer, Map<String, Integer>> courseMap;
    
    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }
        
        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }
        
        List<String> answer = new ArrayList<>();
        
        for (Map<String, Integer> count : courseMap.values()) {
            count.values()
                .stream()
                .max(Comparator.comparingInt(o -> o))
                .ifPresent(cnt -> count.entrySet()
                           .stream()
                           .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                           .forEach(entry -> answer.add(entry.getKey()))
                  );
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public static void combinations(int idx, char[] order, String result) {
        if (courseMap.containsKey(result.length())) {
            Map<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0) + 1);
        }
        
        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }
}