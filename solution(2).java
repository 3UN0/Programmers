class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m+1][n+1];
        
        // 웅덩이 -1
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][0]][puddles[i][1]] = -1; 
        }
        
        // 시작점
        dp[1][1] = 1;
    
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
               if(dp[i][j] == -1) {
                   // 계산값 영향 없도록
                   dp[i][j] = 0;
                   continue;
                } else {
                   // 우측 이동
                   if(i!=1)
                       dp[i][j] += dp[i-1][j] % 1000000007;
                   // 하단 이동
                   if(j!=1)
                       dp[i][j] += dp[i][j-1] % 1000000007;

                }
            }
        }

        answer = dp[m][n] % 1000000007;
        
        return answer;
    }
}
