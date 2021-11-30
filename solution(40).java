import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Double> failure = new HashMap<>();
        // 실패율 = 스테이지 도달 but 클리어 못한 플레이어 수 / 스테이지 도달 플레이어 수
        
        // 스테이지에 머무른 플레이어 수
        int[] stageCnt = new int[N+1];
        // 스테이지 도달 플레이어 수
        int[] playerCnt = new int[N+1];
        
        for(int i=0;i<stages.length;i++){
            // 마지막 스테이지 제외
            if(stages[i] == N+1){
                continue;
            }
            stageCnt[stages[i]]++;
        }
        
        
        // 스테이지 도달 플레이어 수
        playerCnt[1] = stages.length;
        for(int i=2;i<playerCnt.length;i++){
            playerCnt[i] = playerCnt[i-1] - stageCnt[i-1];
        }
        
        // 실패율 계산하여 map에 저장
        for(int i=1;i<=N;i++){
            // 스테이지에 머무르는 플레이어x -> 실패율 0 
            if(stageCnt[i] == 0){
                failure.put(i, 0d);
                continue;
            }
            double rate = (double) stageCnt[i] / playerCnt[i];
            failure.put(i, rate);
        }
        
        // 정렬 
        for(int i=0;i<N;i++){
            double max = -1;
            int key = 0;
            // keySet() : key목록을 Set형태로 가지고 있음 (전체 출력)
            for(int j : failure.keySet()){
                if(failure.get(j) > max){
                    max = failure.get(j);
                    key = j;
                }
            }
            answer[i] = key;
            failure.remove(key);
        }
        
        
        return answer;
    }
}
