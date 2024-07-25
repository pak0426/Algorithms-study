/*
신고 결과 받기
- 게시판 불량 이용자 신고, 처리 결과 메일 발송 시스템 개발
- 각 유저는 1번에 1명의 유저를 신고
  - 신고 횟수 제한 없음, 1명이 여러 명을 신고 가능 (동일한 유저에 대한 신고 횟수는 1회로 처리)
- k번 이상 신고된 유저는 게시판 이용이 정지, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
- 유저가 신고한 모든 내용을 취합, 한꺼번에 게시판 이용 정지를 시키고 정지 메일 발송

- id_list <= 1000, 같은 아이디가 중복되어 있지 않음
- report <= 200.000, 공백(스페이스)으로 구분되어 있다. 자기 자신을 신고하는 경우는 없다.
- return 결과는 id_list 순서대로 결과 메일 수를 담는다.

- 시간 복잡도를 고려해야한다. n^2가 나온다면 실패할듯
*/

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고당한 유저
        Map<String, Set<String>> reportedUser = new HashMap<>();
        // 처리 결과 메일을 받은 유저
        Map<String, Integer> count = new HashMap<>();
        
        // 1. 신고 기록 조회
        for (String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];
            
            // 2. 신고당한 기록이 없다면
            if (!reportedUser.containsKey(reportedId)) {
                reportedUser.put(reportedId, new HashSet<>());
            }
            
            // 3. 신고한 사람의 아이디를 해시맵의 value인 셋에 추가
            reportedUser.get(reportedId).add(userId);
        }
        
        for (Map.Entry<String, Set<String>> entry : reportedUser.entrySet()) {
            // 4. 신고자의 수가 정지 기준에 만족하는지 확인
            if (entry.getValue().size() >= k) {
                // 5. 셋을 돌면서 count 계산
                for (String uid : entry.getValue()) {
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        
        // 6. 각 id별 메일을 받은 횟수를 순서대로 정리
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }
    
        return answer;
    }
}