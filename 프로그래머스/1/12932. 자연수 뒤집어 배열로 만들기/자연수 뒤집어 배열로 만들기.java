import java.util.*;

class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        
        int[] arr = new int[str.length()];
        
        int j = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            arr[j++] = c - '0';
        }
        
        return arr;
    }
}