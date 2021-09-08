import java.util.ArrayList;

class Solution {
    public static int answer = 0;
    // 문자열로 만들 수 있는 수 저장
    public static ArrayList<Integer> list = new ArrayList<>();
    // 문자열의 몇번째 인덱스 방문했는지 체크
    public static boolean[] check = new boolean[7];
    
    public int solution(String numbers) {
        // 숫자 조합으로 만들기 위한 변수
        String temp = "";
        
        // 만들 수 있는 수의 자리수만큼 반복
        for(int i=1;i<=numbers.length();i++){
            allNum(numbers, temp, i);
        }
        
        for(int i=0;i<list.size();i++){
            prime(list.get(i));
        }
        
        return answer;
    }
       
    // numbers로 만들 수 있는 모든 수 구하기
    public static void allNum(String n, String temp, int len){
        // 종료조건 : temp에 붙인 숫자 길이 == 현재 숫자 자릿수
        if(temp.length() == len){
            // 중복 방지
            if(!list.contains(Integer.parseInt(temp)))
                list.add(Integer.parseInt(temp));
            return;
        }
        
        for(int j=0;j<n.length();j++){
            if(!check[j]){
                // temp에 붙여나가며 숫자 조합, 방문 처리
                temp+= n.charAt(j);
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
    
    // 소수 찾는 메소드
    public static void prime(int number){
        if(number == 0){
            return;
        }
        if(number == 1){
            return;
        }
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number % i == 0){
                return;
            }
        }
        // 소수일 경우 answer 증가
        answer++;
    }
}
