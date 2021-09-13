import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    
    public static ArrayList<String> list = new ArrayList<>();
    public static boolean[] check;
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        // 문자열 만들기 위한 변수
        String temp = "";
        
        check = new boolean[numbers.length];
        // 만들 수 있는 수의 자리수만큼 반복
        for(int i=1;i<=numbers.length;i++){
            allNum(str, temp, i);
        }
        
        /*
        for(int i=0;i<numbers.length;i++){
            temp += String.valueOf(numbers[i]);
            System.out.println(temp);
            list.add(temp);
        }
        */
        
        Collections.sort(list);
        answer = list.get(list.size()-1);
        
        return answer;
    }
    // numbers로 만들 수 있는 모든 수 구하기
    public static void allNum(String[] n, String temp, int len){
        // 종료조건 : temp에 붙인 숫자 길이 == 현재 숫자 자릿수
        if(temp.length() == len){
            // 중복 방지
            if(!list.contains(temp))
                list.add(temp);
            return;
        }
        
        for(int j=0;j<n.length;j++){
            if(!check[j]){
                // temp에 붙여나가며 숫자 조합, 방문 처리
                temp+= n[j];
                check[j] = true;
            
                // 재귀 : 현재 몇 자리의 숫자 만드는지
                allNum(n, temp, len);
                // 모든 숫자 조합 완료, 직전 방문 인덱스 false 변환
                check[j] = false;
                // temp 변수에서 마지막 자리의 숫자 제외하고 갱신
                temp = temp.substring(0,temp.length()-1);
            }
            
        }
        
    }
    
}
