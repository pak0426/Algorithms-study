/*
문제 파악
- 작업의 개수 100이하
- 작업 진도 100미만의 자연수
- 작업 속도는 100이하의 자연수
*/

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        int[] days = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int day = 1;
            while (true) {
                int end = progress + (day * speeds[i]);
                
                if (end >= 100) break;
                else day++;
            }
            days[i] = day;
        }
        
        int count = 0;
        int maxDay = days[count];
        
        for (int i = 0; i < days.length; i++) {
            if (days[i] <= maxDay) {
                count++;
            }
            else {
                answer.add(count);
                count = 1;
                maxDay = days[i];
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}