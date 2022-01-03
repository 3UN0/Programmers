class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 연속된 숫자의 합 -> 1부터 더하다가 n과 같아지면 count++
        // 숫자 합 -> n보다 커지면 n이 될 수 없음 -> break 후 다음으로
        // n자체도 하나의 경우의 수 가능 -> n포함
        
        for(int i=1;i<=n;i++){
            int sum = 0;
            for(int j=i;j<=n;j++){
                sum+=j;
                if(sum==n){
                    answer++;
                    break;
                } else if(sum>n){
                    break;
                }
            }
        }
        
        return answer;
    }
}
