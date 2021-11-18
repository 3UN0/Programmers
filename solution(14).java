import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 전화번호 정렬
        Arrays.sort(phone_book);
        
        // 뒷문장과 앞문장 비교하여 
        // 뒷문장이 앞문장으로 시작하는지 (startWith) 비교
        for(int i=0;i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
               
        return answer;
    }
}
