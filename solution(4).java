import java.util.*;

class Solution {
    static boolean[] visit;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visit = new boolean[words.length];
        
        // bfs -> 큐 생성 (LinkedList<>() 사용)
        Queue<Node> queue = new LinkedList<>();

        // 시작 단어 노드에 저장
        queue.offer(new Node(begin, 0));
        
        while(!queue.isEmpty()){
            // 큐에서 맨 위 값 제거 (값 저장)
            Node node = queue.poll();
            
            if(node.word.equals(target)){
                // begin = target 같으면 0 반환
                return node.count;
            }
            
            for(int i=0;i<words.length;i++){
                // begin 단어랑 words 배열 비교해서 isChange단어 있으면 offer
                if(!visit[i] && isChange(node.word, words[i])) {
                    queue.offer(new Node(words[i], node.count+1));
                    visit[i] = true;
                }
            }   
        }
        return answer;
    }

    // 두 스트링 비교해서 한 글자만 다른 경우 true 반환
    public boolean isChange(String start, String end){
        int diff = 0;
        
        for(int i=0;i<start.length();i++){
            if(start.charAt(i) != end.charAt(i)){
                diff++;
            }
        }    
        // 한 글자 다른 경우
        if(diff == 1)
            return true;
        
        return false;
    }
    
}

class Node {
    String word;
    int count;
    
    Node(String word, int count){
        this.word = word;
        this.count = count;
    }
}
