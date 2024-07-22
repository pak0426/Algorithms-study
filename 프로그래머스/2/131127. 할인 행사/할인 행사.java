import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        System.out.println("answer = " + answer);
        System.out.println(map);
        
        for (int i = 0; i < discount.length; i++) {
            Map<String, Integer> newMap = new HashMap<>(map);
            for (int j = i; j < i + 10; j++) {
                if (i <= discount.length - 10) {
                    String key = discount[j];   
                    if(newMap.containsKey(key) && newMap.get(key) > 0) {
                        newMap.put(key, newMap.get(key) - 1);
                    }
                }
            }
            int sum = newMap.values().stream().mapToInt(Integer::intValue).sum();
            
            if (sum == 0) {
                answer ++;
            }
        }
        
        
        return answer;
    }
}