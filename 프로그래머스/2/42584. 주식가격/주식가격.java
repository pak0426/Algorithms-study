import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < prices.length; i++) {
            int now = prices[i];
            int sec = 0;
            
            for (int j = i + 1; j < prices.length; j++) {
                int next = prices[j];
                
                if (next >= now) {
                    sec++;
                } else {
                    sec++;
                    break;
                }
            }
            
            list.add(sec);
        }
        
        answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}