class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left;i<=right;i++){
            // 제곱수 -> 약수의 개수 홀수
            if(i % (Math.sqrt(i)) == 0){
                answer -= i;
            }
            // 제곱수x -> 약수의 개수 짝수
            else {
                answer += i;
            }
        }
        
        return answer;
    }
}
