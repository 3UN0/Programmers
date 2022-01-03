import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        ArrayList<Integer> list = new ArrayList<>();
        // 공백 단위로 끊어서 배열에 저장
        String[] str = s.split(" ");
        
        for(int i=0;i<str.length;i++){
            list.add(Integer.parseInt(str[i]));
        }
        
        // Collections 내부 함수 사용 (max / min)
        answer = Collections.min(list) + " " + Collections.max(list);
        
        return answer;
    }
}
