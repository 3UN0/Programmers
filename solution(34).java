import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
    
        // 1. 큐 비었으면 트럭 추가 -> 시간+1
        // 2. 다리 지나면 큐에서 해당 트럭 제거
        // 3. 큐에 트럭 있고, 다음 트럭 추가하면 초과 -> 0으로 추가함 =>시간+1
        // 3-2. 큐에 트럭 있고, 다음 트럭 추가 가능 -> 큐에 트럭 추가 =>시간+1
        
        int sum = 0;
        // 향상된 for문 쓰기 (어차피 트럭 무게로만 측정)
        for(int w : truck_weights){
            
            while(true){
                // 1. 큐 비었을 때
                if(q.isEmpty()){
                    q.offer(w);
                    sum += w;
                    answer++;
                    break;
                }
                // 2. 큐 다 찼을 때
                else if(q.size() == bridge_length){
                    sum -= q.poll();
                }
                // 3. 큐에 트럭 더 추가
                else {
                    // 다음 트럭 추가하면 초과
                    if(sum + w > weight){
                        // 이미 있는 트럭 다리 다 건너도록
                        q.offer(0);
                        answer++;
                    }
                    // 다음 트럭 추가 가능
                    else {
                        q.offer(w);
                        sum+=w;
                        answer++;
                        break;
                    }
                }
            }
            
        }
        // 마지막 트럭도 다리 길이만큼 지나가야 하므로 다리 길이 더하기
        return answer + bridge_length;
    }
}
