class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        long rect = w * h;
        if(w == h){
            return rect - w;
        } else {
            answer = ((long)h -2) * (long)w/2 * 2;
        }
        return answer;
    }
}
