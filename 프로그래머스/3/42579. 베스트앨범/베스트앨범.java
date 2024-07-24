/*
문제 파악
- 장르별로 가장 많이 재생된 노래를 2개씩 모아 베스트 앨범을 출시
- 노래는 고유 번호로 구분
- 수록하는 기준
  - 1. 속한 노래가 많이 재생된 장르를 먼저 수록
  - 2. 장르 내에서 많이 재생된 노래를 먼저 수록
  - 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록

- genres, plays는 배열의 길이가 같고 1 이상 10,000 이하
- 장르 종류는 100개 미만
- 장르에 속한 곡이 1개라면, 1개만 선택
- 모든 장르는 재생된 횟수가 다르다.
*/
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + play);
            
            
            Map<Integer, Integer> playMap = map.getOrDefault(genre, new HashMap<Integer, Integer>());
            playMap.put(i, play);
            map.put(genre, playMap);
        }
        
        List<String> genreList = new ArrayList<>();
        genreMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(m -> genreList.add(m.getKey()));
        
        List<Integer> result = new ArrayList<>();
        for (String genre : genreList) {
            Map<Integer, Integer> playMap = map.get(genre);
            playMap.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())).limit(2)
                .forEach(m -> result.add(m.getKey()));
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}