class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {1, 2, 3, 4, 5, 6, 6};
        
        int right = 0;
        int zero = 0;
        
        for(int i=0;i<lottos.length;i++){
            if(lottos[i] == 0){
                zero++;
            }
        }
        
        
        for(int i=0;i<win_nums.length;i++){
            for(int j=0;j<lottos.length;j++){
                if(win_nums[i] == lottos[j]){
                    right++;
                }
            }
        }
        
        // 최고 순위
        answer[0] = rank[6-zero-right];
        // 최저 순위
        answer[1] = rank[6-right];
        
        return answer;
    }
}
