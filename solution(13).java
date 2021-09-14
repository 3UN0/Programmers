import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // HashMap 만들기
        HashMap<String, Integer> map = new HashMap<>();
        
        // 전화번호부 전체 저장
        for(int i=0;i<phone_book.length;i++){
            map.put(phone_book[i], i);
        }
        
        // 각 전화번호마다 다 분해해서 map에 있는 번호인지 검사
        // 1) 119 -> 1, 11
        // 2) 97674223 -> 9, 97, 976, ...
        // 3) 1195524421 -> 1, 11, 119(존재함), ... 
        for(int i=0;i<phone_book.length;i++){
            for(int j=1;j<phone_book[i].length();j++){
                // substring(0, n) : 인덱스 0부터 j-1 까지 분리
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        
        return answer;
    }
}
