import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] result = {0, 0};
        
        while (s.length() > 1) {
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    result[1]++;
                }
            }
            result[0]++;
            
            int length = s.replace("0", "").length();
            s = Integer.toBinaryString(length);
            
        }
        System.out.println(Arrays.toString(result));
        
        
        
        return result;
    }
}