/*
문제 파악
- dirs는 String, 500이하의 자연수 길이

- 원점을 5,5로 생각하자
*/

import java.util.*;

class Solution {
    // 다음 좌표 결정을 위한 Map 생성
    private static final Map<Character, int[]> location = new HashMap<>();
    
    public int solution(String dirs) {
        initLocation();
        int x = 5, y = 5;
        
        // 똑같은 경로 이동 시 중복을 제거하기 위함
        Set<String> answer = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            // 이동가능한 좌표인지 검증
            if (!isValidMove(nx, ny)) {
                continue;
            }
            
            // A -> B로 이동한 이전, 이후 좌표 기록
            answer.add(x + " " + y + " " + nx + " " + ny);
            
            // B -> A로 이동한 좌표 기록 ( 동일한 이동경로는 1개로 치기 때문 )
            answer.add(nx + " " + ny + " " + x + " " + y);
            
            // 좌표를 이동했으므로 초기화
            x = nx;
            y = ny;            
        }
        return answer.size() / 2;
    }
    

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }
    
    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }
}