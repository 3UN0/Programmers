import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;            
        
        LinkedList<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<priorities.length;i++){
            queue.offer(new int[] {i, priorities[i]});
        }
        
        int count = 0;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            boolean max = true;
            
            for(int j=0;j<queue.size();j++){
                // 중요도 비교 (현재 원소보다 큐에 있는 원소가 클 경우)
                if(cur[1] < queue.get(j)[1]){
                    queue.offer(cur);
                    for(int k=0;k<j;k++){
                        queue.offer(queue.poll());
                    }
                    max = false;
                    break;
                }
            }
            // (현재 원소가 가장 큰 원소가 아닐 때)
            if(max == false)
                continue;
        
            // 현재 원소가 가장 큰 원소일 때
            count++;
            if(cur[0] == location){
                break;
            }   
        }
        answer = count;
        
        return answer;
    }
}
