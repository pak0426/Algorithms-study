class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        boolean flag = true;
        int cnt = 0;
        int zero_cnt = 0;
        while(flag) {
            if(s.length() <= 1) break;
            
            int imsi = s.length() - s.replaceAll("0", "").length();
            zero_cnt += imsi;
            
            s = s.replaceAll("0", "");
            
            s = Integer.toBinaryString(s.length());
            
            cnt++;
        }

        System.out.println("cnt : " + cnt);
        System.out.println("zero_cnt : " + zero_cnt);        
        
        answer[0] = cnt;
        answer[1] = zero_cnt;
        
        return answer;
    }
}