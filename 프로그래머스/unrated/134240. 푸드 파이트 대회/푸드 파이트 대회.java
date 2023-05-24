class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        String front = "";
        String back = "";
        
        for(int i=0; i < food.length; i++) {
            if(i > 0) {
                int imsi = food[i] / 2;
                
                for(int j=0; j < imsi; j++) {
                    front += i;                    
                }
            }
        }
        
        for(int i=front.length()-1; i >= 0; i--) {
            back += front.charAt(i);
        }
        
        answer = front + "0" + back;
        
        return answer;
    }
}