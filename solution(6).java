class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int all = brown + yellow;
        int sqrt = (int)(Math.sqrt(all));

        int x = 0;
        int y = 0;
        
        for(int i=3;i<=sqrt;i++){
            
            if(all%i == 0){
                x = all/i;
                y = all/x;
                
                // 노란색 박스 크기
                int box = (x-2) * (y-2);
                if(x >= y && box == yellow){
                    answer[0] = x;
                    answer[1] = y;
                }
                
            }
        }
        return answer;
    }
}
