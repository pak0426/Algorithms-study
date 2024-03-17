import java.util.*;

class Solution {
    public int solution(String name) {
        
        int xAxis = name.length() - 1;
        int yAxis = 0;
        int len = name.length();
        for (int i = 0; i < len; i++) {
            Character c = name.charAt(i);
            
            int up = c - 'A';
            int down = 'Z' - c + 1;
            yAxis += Math.min(up, down);
            
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }
            xAxis = Math.min(xAxis, (i * 2) + len - next);
            xAxis = Math.min(xAxis, (len - next) * 2 + i);
        }
       
        
        int answer = xAxis + yAxis;
        return answer;
    }
}