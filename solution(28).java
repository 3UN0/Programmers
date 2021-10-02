class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        // 가로 + 세로 - 최대공약수 
        
        // 형변환 : Long width = Long.valueOf(w);
        
        answer = (long)w*h - ((long)w + (long)h - gcd(w, h));    
            
            
        return answer;
    }
    
    // 최대공약수
    public long gcd(long width, long height){
        long big = width;
        long small = height;
        // 큰, 작은 값 설정
        if(width < height){
            big = height;
            small = width;
        }
        
        long temp = 0;
        // 작은 값으로 큰 값 나눠주기 
        while(small > 0){
            temp = big % small;
            big = small; 
            small = temp;
        }
        return big;
    }
}
