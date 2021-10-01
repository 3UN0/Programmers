class Solution {
    public long solution(int price, int money, int count) {
        long sum = price * ((long)count*(count+1)/2);
        
        if(sum <= money){
            return 0;
        } else {
            return sum-(long)money;
            
        }
    }
}
