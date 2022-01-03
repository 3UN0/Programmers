class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int first = doub(n);
        
        while(true){
            if(first == doub(++n)){
                answer = n;
                break;
            }
        }
        
        return answer;
    }
    
    // 이진수 속 1 구하기 -> Integer.bitCount() 활용 가능
    public static int doub(int num){
        int count = 0;
        while(num != 0){
            if(num % 2 == 1)
                count++;
            num = num / 2;
        }
        
        return count;
    }
}
