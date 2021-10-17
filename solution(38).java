import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<operations.length;i++){
            
            // I 숫자
            if(operations[i].contains("I ")){
                String[] str = operations[i].split(" ");
                list.add(Integer.valueOf(str[1]));
                //list.sort(null);
                Collections.sort(list);
            } 
            
            // D 1 ->최댓값 삭제 
            else if(!list.isEmpty() && operations[i].contains("D 1")){
                list.remove(list.size()-1);
            }
            
            // D -1 ->최솟값 삭제
            else if(!list.isEmpty() && operations[i].contains("D -1")){
                list.remove(0);
            }
        }
        
        if(list.isEmpty()){
            answer = new int[]{0,0};
        } else {
            answer = new int[]{list.get(list.size()-1), list.get(0)};
        }
        
        return answer;
    }
}
