import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        //String[] str = s.split(""); -> str[i] 로 사용 가능
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i) == '('){
                stack.push('(');
            } else {
                if(stack.isEmpty()){    // 스택 비어 있는 경우에, ) 입력될 때 (닫는 괄호 더 많을 때)
                    return false;
                } else { // ( ) 딱 맞는 괄호 찾았을 때 
                    stack.pop();
                }
            }
        }
        
        if(stack.isEmpty()){    // 잔여 괄호 없이 끝
            answer = true;
        } else {    // 잔여 괄호 있을 때 
            answer = false;
        }
        
        return answer;
    }
}
