class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        s = s.toLowerCase();
        // 문장 첫 글자 대문자
        sb.append(Character.toUpperCase(s.charAt(0)));
        
        for(int i=1;i<s.length();i++){
            // 공백인 경우
            if(s.charAt(i) == ' '){
                sb.append(" ");
            } 
            // 전 문자열(문자) 공백인 경우 -> e U 
            else if (s.charAt(i-1) == ' '){
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(s.charAt(i));   
            }
        }
        answer = sb.toString();
        return answer;
    }
}
