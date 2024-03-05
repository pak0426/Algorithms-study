class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int leng = s.length();        
        
        if (leng == 1) return 1;
        
        for (int i = 1; i <= leng / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String str = s.substring(0, i);
            int str_leng = str.length();

            int cnt = 0;
            for (int j = 0; j < leng; j+=i) {
                int start = j;
                int end = Math.min(i + j, s.length());
                String com = s.substring(start, end);
                
                if (str.equals(com)) {
                    cnt++;
                }
                else {
                    if (cnt > 1) {
                        sb.append(cnt);
                    }
                    sb.append(str);
                    str = com;
                    cnt = 1;
                }
            }
            
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(str);
            
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}