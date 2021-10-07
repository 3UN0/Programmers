import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visit = new boolean[n+1];
        boolean[][] map = new boolean[n+1][n+1];
        Queue<Integer> queue = new LinkedList<>();
        
        // 1에서 각 노드별로 가는 간선 갯수 저장
        int[] result = new int[n+1];
        
        for(int i=0;i<edge.length;i++){
            int x = edge[i][0];
            int y = edge[i][1];
            
            map[x][y] = true;
            map[y][x] = true;
        }
        
        queue.add(1);
        visit[1] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                // 처음 입력된 값 출력
                int now = queue.poll();
                for(int j=1;j<=n;j++){
                    if(map[now][j] && !visit[j]){
                        visit[j] = true;
                        queue.add(j);        
                    }
                }
            }
            answer = size;
        }
        
        return answer;
    }
    
}
