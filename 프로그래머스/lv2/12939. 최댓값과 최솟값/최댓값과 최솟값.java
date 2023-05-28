import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String arr[] = s.split(" ");
        
        System.out.println(arr[0]);
        
        String min = arr[0];
        String max = arr[0];
        for (int i=0; i < arr.length; i++) {
            if (Integer.parseInt(min) > Integer.parseInt(arr[i])) min = arr[i];
            if (Integer.parseInt(max) < Integer.parseInt(arr[i])) max = arr[i];
        }
        answer = min + " " + max;
        
        return answer;
    }
}