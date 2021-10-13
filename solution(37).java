import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 1. 장르별 총 재생횟수 합산
        for(int i=0;i<genres.length;i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 답안용 리스트
        ArrayList<Integer> ans = new ArrayList<>();
        // 장르 정렬 -> key값 가져오기 
        ArrayList<String> list = new ArrayList<>(map.keySet());
        // 장르 재생횟수에 따라 내림차순 정렬 
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                // return map.get(o2).compareTo(map.get(o1));
                return map.get(o2) - map.get(o1);
            }
        });

        // 2. 장르 내 재생 횟수 비교
        for(int i=0;i<list.size();i++){
            String g = list.get(i);
            int firstidx = -1;
            int secidx = -1;
            int max = 0;
            // 1) 첫번째 값 구하기
            for(int j=0;j<genres.length;j++){
                // 재생 많은 순 장르 = 배열 값
                if(g.equals(genres[j])){
                    // max와 비교해서 최다 재생 횟수 갱신
                    if(max < plays[j]){
                        max = plays[j];
                        firstidx = j;
                    }
                }
            }
            
            // 2) 두번째 값 구하기
            max = 0;
            for(int j=0;j<genres.length;j++){
                if(g.equals(genres[j])){
                    // max와 비교, 첫번째 값 인덱스 경우
                    if(j != firstidx && max < plays[j]){
                        max = plays[j];
                        secidx = j;
                    }
                }
            }
            
            // 첫번째 값 추가
            ans.add(firstidx);
            // 두번째 값 추가 (장르 내 곡 하나일 수도 있음)
            if(secidx >= 0)
                ans.add(secidx);
               
        }
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}
