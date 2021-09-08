import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i =0;      //a
        for(i =0; i<completion.length;i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }   
        }
        return participant[i];
            
        //String[] temp = new String[1];
        //int i=0;
        //for(i=0;i<participant.length;i++){
         ///   for(int j=0;j<completion.length;j++){
          //      if(participant[i].equals(completion[j])){
          //          temp[0] = "";
          //      } else {
          //          temp[0] = participant[i];
          //      }
           // }
        
       // }
        
        //return temp[0];
    }
}
