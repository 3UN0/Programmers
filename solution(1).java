class Solution {
    private int answer = -1;
    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer;
    }
    
    public void dfs(int n, int number, int count, int val) {
        // 8 초과
        if(count>8) {
            answer = -1;
            return;
        }
        
        // 8 이하에서 수 만든 경우
        if(val == number){
            if(answer > count || answer == -1){
                answer = count;
                return;
            }
        }
        
        int temp = n;
        for(int i=0;i<8-count;i++){
            dfs(n, number, count + i + 1, val + temp);
            dfs(n, number, count + i + 1, val - temp);
            dfs(n, number, count + i + 1, val * temp);
            dfs(n, number, count + i + 1, val / temp);
            temp = temp*10 + n;
        }
        
    }
}
