class Solution {
    public String solution(String s) {
        String answer = "";           
        int input_length = s.length();        
        int half = input_length / 2;        
        if(input_length % 2 == 0){            
            answer = s.substring(half-1, half+1);            
        }else{            
            answer = s.substring(half, half+1);            
        }
        return answer;
    }
}