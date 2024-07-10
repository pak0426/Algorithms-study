/*
문제 분석
- 실패율을 구하는 코드를 구하자.
- 실패율 = 스테이지 도달했지만 클리어 못한 플레이어 수 / 스테이지 도달한 플레이어 수
- 전체 스테이지 개수 = N
- 게임을 이용하는 사용자가 현재 멈춰있는 스테이지 번호가 담길 배열 = stages
- 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담긴 배열을 return

- 스테이지 개수는 500이하, stages 길이는 200,000 이하 이므로 시간 복잡도 생각안해도 됨
- N + 1은 마지막 스테이지까지 클리어한 사용자임
- 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0
*/
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 결과 배열 초기화, 결과 길이는 N과 같다.
        int[] answer = new int[N];
        int user = stages.length;
        
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int stage = i + 1;
            int count = (int) Arrays.stream(stages).filter(value -> value == stage).count();
            
            if (count == 0) {
                map.put(stage, 0.0);                
            }
            else {
                double fail = (double) count / user;
                map.put(stage, fail);
                user = user - count;    
            }
        }
        answer = map.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(Map.Entry::getKey).toArray();
        
        return answer;
    }
}