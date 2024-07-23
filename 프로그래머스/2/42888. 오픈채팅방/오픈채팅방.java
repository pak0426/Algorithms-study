/*
문제 파악
- 오픈 채팅방, 가상의 닉네임
- 관리자창을 만듬 (사람들이 들어오고 나가는걸 모니터링)
- 닉네임 변경 방법
  - 채팅방을 나간 후 새로운 닉네임으로 들어간다
  - 채팅방에서 닉네임 수정
- 닉네임 수정시 기존 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경
- 닉네임 변경한 기록이 담긴 문자열 record가 매개변수로 주어질 때, 모든 기록이 처리된 후, 
  최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return
  
- record는 1 이상 100,000이하
*/

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // map을 통해 마지막 닉네임 저장, 변경 또는 재입장
        Map<String, String> map = new HashMap<>();
        
        for (String s : record) {
            String[] words = s.split(" ");
            
            if (words[0].equals("Enter") || words[0].equals("Change")) {
                map.put(words[1], words[2]);
            }
        }
        
        // result 만들기
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String s = record[i];
            String[] words = s.split(" ");
            
            if (words[0].equals("Enter")) {
                answers.add(map.get(words[1]) + "님이 들어왔습니다.");
            }
            else if(words[0].equals("Leave")) {
                answers.add(map.get(words[1]) + "님이 나갔습니다.");
            }
        }
        
        return answers.toArray(new String[answers.size()]);
    }
}