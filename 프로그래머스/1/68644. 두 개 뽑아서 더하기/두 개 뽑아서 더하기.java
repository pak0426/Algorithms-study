import java.util.*;

class Solution {
    /*
     * numbers의 길이가 100이하이므로 시간 복잡도를 고려하지 않아도 된다.
     */ 
    public int[] solution(int[] numbers) {
        int[] answer = {};
        List<Integer> list = new ArrayList<Integer>();
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }
        answer = list.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}