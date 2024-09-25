import java.util.*;

public class Solution {

    public long solution(long n) {
        String str = String.valueOf(n);
        String[] arr = str.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        return Long.parseLong(sb.toString());
    }

}