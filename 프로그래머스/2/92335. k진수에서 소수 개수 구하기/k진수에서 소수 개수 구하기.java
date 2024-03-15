import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        sb.reverse();
        String[] arr = sb.toString().split("0");
        
        int result = 0;
        for (String str : arr) {
            if (str.isEmpty() || str.equals("1")) {
                continue;
            }
            
            long a = Long.parseLong(str);
            if (isPrime(a)) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(long a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}