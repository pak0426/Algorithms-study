import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        int standard = 0;
        for (int i = 0; i < progresses.length; i++) {
            int now = progresses[i];
            int speed = speeds[i];
            int remain = 100 - now;
            int days = remain / speed;
            if (remain % speed > 0) {
                days += 1;
            }
            
            if (days > standard) {
                standard = days;
                list.add(1);
            } else {
                int lastIndex = list.size() - 1;
                int last = list.get(lastIndex);
                list.set(lastIndex, ++last);
            }
        }
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}