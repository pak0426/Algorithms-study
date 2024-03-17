import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        
        List<Set<Integer>> dp = new ArrayList();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet());
        }
        
        
        dp.get(1).add(N);
        
        for (int i = 2; i < 9; i++) {
            Set<Integer> set = dp.get(i);
            
            StringBuilder sb = new StringBuilder().append(N);
            for (int j = 1; j < i; j++) {
                sb.append(N);
            }
            dp.get(i).add(Integer.parseInt(sb.toString()));
            
            for (int j = 1; j < i; j++) {
                int k = i - j;
                
                for (Integer prev : dp.get(j)) {
                    for (Integer next: dp.get(k)) {
                        dp.get(i).add(prev + next);
                        dp.get(i).add(prev - next);
                        dp.get(i).add(prev * next);
                        
                        if (next != 0) {
                            dp.get(i).add(prev / next);
                        }
                    }
                }
            }
            
            if (dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}