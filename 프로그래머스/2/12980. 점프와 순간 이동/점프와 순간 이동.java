import java.util.*;

public class Solution {
    public int solution(int n) {
        int battery = 0;
        
        while (true) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else {
                n--;
                battery++;
            }
            
            if (n == 0) {
                break;
            }
        }
        
        return battery;
    }
}