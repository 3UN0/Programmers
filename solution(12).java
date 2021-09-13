import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] str = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            // 숫자 -> 문자열 변환
            str[i] = String.valueOf(numbers[i]);
        }
        
        // 정렬
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                // 더 큰 값이 먼저 위치하도록 자동으로 정렬됨 (내림차순)
                return ((o2+o1).compareTo(o1+o2));
            }
        });
        
        // 000과 같이 0이 여러번인 경우
        if(str[0].equals("0")){
            return "0";
        }
        
        for(int i=0;i<str.length;i++){
            answer += str[i];
        }
        
        return answer;
    }
    
    
}
