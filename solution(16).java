class Solution {
    public String solution(int n) {
        String answer = "";
        
        // n % 3 = 0, 1, 2 (나머지 0, 1, 2 순서) 
        String[] numbers = {"4", "1", "2"};
        
        int num = n;
        
        while(num > 0){
            // 나머지
            int remain = num % 3;
            // 몫 구하기 (124 나라 숫자 두자리 이상)
            num /= 3;
            
            // 3으로 나눠지는 경우 (나머지 0)
            if(remain == 0) num--;
            
            // 문자열에 붙여야 함
            answer = numbers[remain] + answer;    
        }
        return answer;
    }
}
