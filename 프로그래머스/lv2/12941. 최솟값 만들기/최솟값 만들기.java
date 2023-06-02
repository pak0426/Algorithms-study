import java.util.*;
import java.util.stream.Collectors;

class Solution
{
    public int solution(int[] a, int[] b)
    {
        int answer = 0;
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        for (int i=0; i < a.length; i++) {
            answer += a[i] * b[a.length-1-i];
        }
       

        return answer;
    }
}