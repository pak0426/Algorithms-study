class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String [] word = {"aya", "ye", "woo", "ma"};
        //String [] word = {"ma", "woo", "ye", "aya"};
        //String [] word = {"ye", "woo", "aya", "ma"};
        String [] two_word = {"ayaaya", "yeye", "woowoo", "mama"};
        //String [] two_word = {"mama", "woowoo", "yeye", "ayaaya"};
        //String [] two_word = {"yeye", "woowoo", "ayaaya", "mama"};
        
        for(int i=0; i < babbling.length; i++) {
           
            String imsi = babbling[i];
           
            for(int j=0; j < two_word.length; j++) {
                if(imsi.contains(two_word[j]) == true) {
                    imsi = imsi.replace(word[j], "!");
                }
            }
            
            for(int j=0; j < word.length; j++) {
                if(imsi.contains(word[j]) == true) {
                    imsi = imsi.replace(word[j], " ");
                }
            }
            
            imsi = imsi.replace(" ", "");
            
            if(imsi.equals("")) {
                answer++;
            }
        }
        
        return answer;
    }
}