import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        // 힙 : 우선순위 큐 로 구현
        // 자동 오름차순 정렬됨
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int answer = 0;
        
        // 힙에 주어진 배열의 값 모두 입력
        for(int i=0;i<scoville.length;i++){
            heap.offer(scoville[i]);
        }
        
        // heap 가장 윗 값이 k보다 작으면 반복 (k이상이 되도록)
        while(heap.peek() < K){
            // 힙 사이즈가 1이면 더 이상 계산 불가
            if(heap.size() == 1) {
                answer = -1;
                break;
            }
            
            int a = heap.poll();
            int b = heap.poll();
            
            int result = a + (b*2);
            heap.offer(result);
            answer++;
        }
        
        return answer;
    }
}
