import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=progresses.length-1;i>=0;i--){
            
            stack.add((100-progresses[i]) / speeds[i] + ((100-progresses[i]) % speeds[i] > 0 ? 1 : 0));
            
        }
        while(!stack.isEmpty()){
            int cnt = 1;
            int top = stack.pop();
            while (!stack.isEmpty() && stack.peek() <= top) {
			    cnt++;
			    int a = stack.pop();
		    }
            list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
