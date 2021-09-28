class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int wdt = 0;
        int hgt = 0;
        
        for(int i=0;i<sizes.length;i++){
            int a = Math.max(sizes[i][0], sizes[i][1]);
            int b = Math.min(sizes[i][0], sizes[i][1]);
            
            wdt = Math.max(wdt, a);
            hgt = Math.max(hgt, b);
        }
        
        return answer = hgt*wdt;
    }
}
