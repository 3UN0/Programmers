import java.util.ArrayList;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        // Map<String, Integer> map = new HashMap<>();
        
        ArrayList<String> list = new ArrayList<>();
        // 이전 단어로 비교
        String prev = "";
        
        int people = 0;
        int game = 1;
        for(int i=0;i<words.length;i++){
            String now = words[i];
            people++;
            
            // 첫번째 단어 제외
            if(i>0){
                char first = now.charAt(0);
                char last = prev.charAt(prev.length()-1);
                
                if(last != first || list.contains(now)){
                    answer[0] = people;
                    answer[1] = game;
                    break;
                }
                
            }
            
            
            list.add(now);
            prev = now;
            // n명 주기 한바퀴 돌았을 때 변수 초기화
            if(people == n){
                people = 0;
                game++;
            }
            
        }

        return answer;
    }
}
