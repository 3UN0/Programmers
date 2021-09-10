import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long low = 0;
        // 가장 오래 걸리는 심사관이 n명을 심사할 경우 (가장 오래 걸림)
        long high = n * (long)times[times.length-1];
        
        while(low <= high){
            // 심사를 받는 데 주어진 시간
            long mid = (low + high) / 2;
            // 총 심사한 인원
            long sum = 0;
            // 시간값 / 각 심사관 별 심사시간 = 심사관 당 맡을 수 있는 입국자 수
            for(int i=0;i<times.length;i++){
                sum += mid/times[i];
                
            }
            // 심사 다 못함 -> 시간 더 많이 필요
            if(n > sum){
                low = mid + 1;
            }
            // 심사 인원 초과 -> 시간 최대한 줄이기
            else {
                high = mid - 1;
                answer = mid;
            }
        }
        
        
        return answer;
    }
}
