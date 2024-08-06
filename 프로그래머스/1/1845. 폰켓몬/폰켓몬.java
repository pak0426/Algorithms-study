/*
문제 파악
- 홍 박사님 연구실의 포켓몬 N 마리 중 N/2 마리를 가져가도 됌
- 포켓몬은 종류에 따라 번호를 붙여 구분, 같은 종류의 포켓몬은 같은 번호
- 가질 수 있는 포켓몬 종류 수의 최대 값을 구해라
*/

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int cnt = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            
            if (set.size() == cnt) {
                break;
            }
        }
        
        return set.size();
    }
}