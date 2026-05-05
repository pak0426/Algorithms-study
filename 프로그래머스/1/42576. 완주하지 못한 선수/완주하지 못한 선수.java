import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : participant) {
            int v = map.getOrDefault(s, 0);
            map.put(s, v + 1);
        }
        
        for (String c : completion) {
            int v = map.getOrDefault(c, 0);
            
            if (v != 0) {
                map.put(c, v - 1);
            }
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}