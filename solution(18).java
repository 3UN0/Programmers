import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;


class Solution {
    public int solution(int[][] jobs) {
        
        // 원본배열 오름차순 정렬 (요청시간 오름차순)
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                return arr1[0] - arr2[0];
            }
        });
        
        // Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        return schedule(jobs);
    }
    
    // 처리 시간 오름차순으로 정렬
    public int schedule(int[][] jobs){
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            
            @Override
            public int compare(int[] arr1, int[] arr2){
                return arr1[1] - arr2[1];
            }
       
        });
    
        queue.offer(jobs[0]);
        int end = jobs[0][0];   // 수행되고 난 후 시간 end
        int sum = 0;
        int idx = 1;
        
        // 큐 빌 때까지 계속 반복
        while(!queue.isEmpty()){
            // 수행 시간 짧은 요청부터 먼저 수행
            int[] now = queue.poll();
            end += now[1];
            sum += end - now[0];
            System.out.println(sum);
            
            // 하나의 작업 완료 시점(end)까지 들어온 모든 요청 큐에 넣음
            while(idx < jobs.length && jobs[idx][0] <= end){
                queue.offer(jobs[idx++]);
            }
            
            // 준비큐는 비어있으나 웨이팅큐는 비어있지 않은 경우
            // 작업 완료(end) 후 다음 요청 들어옴
            if(idx < jobs.length && queue.isEmpty()) {
                end = jobs[idx][0];
                queue.offer(jobs[idx++]);
            }
        
        }
    
        return sum/jobs.length;
    }
}
