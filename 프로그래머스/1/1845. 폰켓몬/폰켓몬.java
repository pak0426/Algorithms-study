import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 0);
        }
        
        int realMax = map.keySet().size();
        
        if (max > realMax) {
            return realMax;
        } else {
            return max;
        }
    }
}