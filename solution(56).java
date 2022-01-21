class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        String str = "";
        
        for(int i=1;i<s.length();i++){
            char prev = s.charAt(i-1);
            char now = s.charAt(i);
            
            if(now ==(prev)){
                    System.out.println(str);
                for(int j=now+1;j<s.length();j++){
                    str += s.charAt(j);
                }
                s = str;
            } else {
                str += prev;
            }
            
            if(s.length() == 0){
                answer = 1;
            } else {
                answer = 0;
            }
            
            
        }

        return answer;
    }
}
