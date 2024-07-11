/*
문제 파악
- dirs는 String, 500이하의 자연수 길이

- 원점을 5,5로 생각하자
*/

import java.util.*;

class Solution {
    private int x = 5;
    private int y = 5;
    
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {      
            String before = x + " " + y;
            
            if (dirs.charAt(i) == 'U') {
                if (!up()) continue;
            } else if (dirs.charAt(i) == 'D') {
                if (!down()) continue;
            } else if (dirs.charAt(i) == 'L') {
                if (!left()) continue;
            } else {
                if (!right()) continue;
            }
            
            String after = x + " " + y;
            set.add(before + "^" + after);
            set.add(after + "^" + before);
        }
        
        return set.size() / 2;
    }
    
    public boolean left() {
        if (x <= 0) {
            return false;
        }
        x -= 1;
        return true;
    }
    
    public boolean right() {
        if (x >= 10) {
            return false;
        }
        x += 1;
        return true;
    }
    
    public boolean up() {
        if (y >= 10) {
            return false;
        }
        y += 1;
        return true;
    }
    
    public boolean down() {
        if (y <= 0) {
            return false;
        }
        y -= 1;
        return true;
    }
}