import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        
        for(int i=0;i<d.length;i++){
            // sum += d[i];
            // if(sum > budget){
            //    break;
            //  }
            // answer++;
            if(sum + d[i] > budget){
                break;
            }
            sum+=d[i];
            answer++;
        }
        
        return answer;
    }
}