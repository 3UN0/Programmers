import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=1;i<=citations.length;i++){
            int in = 0, notin = 0;
            for(int j=0;j<citations.length;j++){
                if(citations[j] > i){
                    in++;
                } else if (citations[j] == i){
                    in++;
                    notin++;
                } else {
                    notin++;
                }
            }
            if(in >= i && notin <= i){
                answer = Math.max(answer, i);
            }
        }
        
        return answer;
    }
}
