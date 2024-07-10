import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int user = stages.length;
        Map<Integer, Double> fails = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            int stage = i + 1;
            int count = (int) Arrays.stream(stages).filter(value -> value == stage).count();
            
            if (count == 0) {
                fails.put(stage, 0.0);
            }
            else {
                double fail = (double) count / user;
                fails.put(stage, fail);
                
            }
            user = user - count;
        }
        
        
        answer = fails.entrySet().stream()
            .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(Map.Entry::getKey)
            .toArray();
        
        return answer;
    }
}