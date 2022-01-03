class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        // 배열의 첫번째 값 저장 -> 기준
        answer = arr[0];
        for(int i=1;i<arr.length;i++){
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    // 최대공약수 ; 유클리드 호제법 
    public static int gcd(int a, int b){
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        
        while (y!=0){
            int r = x%y;
            x = y;
            y = r;
        }
        return x;
    }
    
    // 최소공배수 : 두 수의 곱 / 최대공약수
    public static int lcm(int a, int b){
        return a*b/gcd(a, b);
    }
    
}
