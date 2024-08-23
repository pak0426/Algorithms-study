import java.util.*;

class Solution {
    private int answer = 0;
    private int depth = 0;
    private int sum = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, depth, target, sum);
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return;
        }
        dfs(numbers, depth + 1, target, sum + numbers[depth]);
        dfs(numbers, depth + 1, target, sum - numbers[depth]);
    }
}