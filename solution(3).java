class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 각 배열 원소 방문 표시 -> false 시작
        boolean[] visit = new boolean[n];
        
        for(int i=0;i<n;i++){
            // visit가 false일 때
            if(!visit[i]){
                dfs(computers, i, visit);
                
                answer++;
            }   
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int node, boolean[] visit){
        // 방문 노드 true로 변경
        visit[node] = true;
        
        // 각 노드에 담긴 원소 확인
        for(int i=0;i<computers.length;i++){
            if(node!=i && visit[i]==false && computers[node][i]==1){
                dfs(computers, i, visit);
            }
        }
    }
}
