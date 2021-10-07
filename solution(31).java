// 플로이드 와샬 알고리즘 -> 어떤 노드가 있을 때 그 노드의 입출 노드의 간선 수가 n-1 이어야 함

import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] results) {
        // 모든 정점에서 갈 수 있으면, 그 정점은 비교 가능한 대상이 됨
        // win[i][j] or win[j][i] 하나라도 있으면 모든 정점에서 갈 수 있는 것
        int answer = 0;
        int INF = 100001;
        int[][] win = new int[n+1][n+1];
        
        // 모든 경로 INF로 채우기
        for(int[] arr : win){
            Arrays.fill(arr, INF);
        }
        
        // 플로이드 와샬 표 채우기
        for(int i=0;i<results.length;i++){
            int a = results[i][0];
            int b = results[i][1];
            win[a][b] = 1;
        }
        
        // 해당 정점으로 도착할 수 있는 정점의 수 -> 해당 정점의 순위
        // 해당 정점에서 출발할 수 있는 정점의 수 -> 해당 정점 이후의 순위
        // 도착할 수 있는 정점의 수 + 출발할 수 있는 정점의 수 => 전체 정점의 개수 - 1(본인) => 순위 파악 가능!
        
        for(int i=1;i<win.length;i++){  // 거치는 경로
            for(int j=1;j<win.length;j++){  // 시작 정점
                for(int k=1;k<win.length;k++){  // 도착 정점
                    if(win[j][k] > win[j][i]+win[i][k])
                        win[j][k] = win[j][i] + win[i][k];
                }
                
            }
            
        }
        
        for(int i=1;i<win.length;i++){
            boolean flag = true;
            for(int j=1;j<win[i].length;j++){
                if(i == j) continue;
                if(win[i][j] == INF && win[j][i] == INF){
                    flag = false;
                    break;
                }
            }
            if(flag)
                answer++;
        }
        
        
        return answer;
    }
}
