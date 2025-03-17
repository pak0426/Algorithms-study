import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        Map<Integer, Integer> weightMap = new HashMap<>();
        long answer = 0;
        
        for (int weight : weights) {
            // 같은 무게 (1:1)
            if (weightMap.containsKey(weight)) {
                answer += weightMap.get(weight);
            }
            
            // 무게 비율 2:1 (거리 비율 1:2)
            if (weight % 2 == 0 && weightMap.containsKey(weight/2)) {
                answer += weightMap.get(weight/2);
            }
            
            // 무게 비율 3:2 (거리 비율 2:3)
            if (weight % 3 == 0 && weightMap.containsKey(weight*2/3)) {
                answer += weightMap.get(weight*2/3);
            }
            
            // 무게 비율 4:3 (거리 비율 3:4)
            if (weight % 4 == 0 && weightMap.containsKey(weight*3/4)) {
                answer += weightMap.get(weight*3/4);
            }
            
            // 현재 무게 추가
            weightMap.put(weight, weightMap.getOrDefault(weight, 0) + 1);
        }
        
        return answer;
    }
}