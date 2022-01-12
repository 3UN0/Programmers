import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        
        // n행 4열
        for(int i=1;i<n;i++){
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }
        // dp로 줄마다 가능한 최댓값 수 저장 -> 마지막 줄에서는 16 15 3 1 이런식으로 저장됨 -> 최댓값 return
        for(int i=0;i<4;i++){
            answer = Math.max(answer, land[n-1][i]);
        }
        
        return answer;
    }
}
