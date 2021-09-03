import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static boolean[] visited;
    public static ArrayList<String> result;
        
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        
        dfs("ICN", "ICN", 0, tickets);
        // 알파벳 순으로 경로 정렬
        Collections.sort(result);
        // 각 경로 잘라서 저장
        String[] answer = result.get(0).split(" ");    
            
        return answer;
    }
    
    static void dfs(String now, String end, int count, String[][] tickets){
        
        if(count == tickets.length){
            result.add(end);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            // 티켓 사용 x, 해당 티켓 출발지가 현재 위치와 같은 경우
            if(!visited[i] && tickets[i][0].equals(now)){
                // 티켓 사용 o
                visited[i] = true;
                // 도착지 list에 저장, count+1
                dfs(tickets[i][1], end + " " + tickets[i][1], count+1, tickets);
                visited[i] = false; // 반복 시키기 위해서
            }
            
        }
    }
    
}
