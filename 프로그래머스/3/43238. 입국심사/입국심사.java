/*
문제 파악
- n명이 입국 심사를 위해 줄을 서서 기다리고 있다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다르다.

- 1개의 심사대에서는 동시에 1명만 심사 가능
- 모든 사람이 심사를 받는 시간을 최소로 하고 싶다.

- 입국 심사 기다리는 사람 n, 심사관들이 한 명 심사하는데 걸리는 시간 배열 times
- 모든 심사를 받는데 걸리는 시간을 리턴

1 <= n <= 1,000,000,000
1 <= 시간 <= 1,000,000,000

시간 복잡도를 고려해야 한다.
*/

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        
        long start = times[0];
        long end = (long) times[times.length - 1] * n;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0L;
            
            for (int time : times) {
                sum += mid / time;
            }
            
            System.out.println(sum);
            if (sum >= n) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}