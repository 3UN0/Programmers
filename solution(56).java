import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        // for(char c : s.toCharArray())
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            // 스택에 변수 있을 때 , 스택의 최근 저장값이 현재 변수와 같을 때
            // 연속으로 같은 알파벳
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        if(stack.isEmpty()){
            return 1;
        } else {
            return 0;
        }
        
    }
}
