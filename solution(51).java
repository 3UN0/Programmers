class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left;i<=right;i++){
            int sum = dub(i);
            if(sum % 2 == 0){
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
    public static int dub(int num){
        int count = 0;
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num % i == 0){
                if(Math.sqrt(num) == i){
                    count++;
                } else {
                    count+=2;
                }
            }
        }
        return count;
    }
    
}
