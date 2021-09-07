class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length; //전체학생-잃어버린학생
        
        //잃어버린 학생이 여분있는 학생인지 여부 (참: -1, reserve x)
        for(int i=0;i<reserve.length;i++){
            for(int j=0;j<lost.length;j++){
                // 빌려줄 수 없음
                if(lost[j] == -1 && reserve[i] == -1){
                    continue;
                }
                //여분x -> 본인만 o (+1)
                if(lost[j] == reserve[i]){
                    lost[j] = -1;
                    reserve[i] = -1;
                    answer++;
                }
            }
        }
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i] == -1 || reserve[j] == -1){
                    continue;
                }
                if(Math.abs(lost[i]-reserve[j]) == 1){
                    answer++;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
