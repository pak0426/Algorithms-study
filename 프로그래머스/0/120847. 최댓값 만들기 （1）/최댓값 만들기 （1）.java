import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        int length = numbers.length;
        
        return numbers[length - 2] * numbers[length - 1];
    }
}