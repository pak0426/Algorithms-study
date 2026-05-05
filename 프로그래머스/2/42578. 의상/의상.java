import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        
        for (String[] arr : clothes) {
            String category = arr[1];
            
            int v = map.getOrDefault(category, 0);
            map.put(category, v + 1);
        }
        
        int result = 1;
        
        for (int v : map.values()) {
            result *= (v + 1);
        }
        
        result -= 1;
        
        return result;
    }
}