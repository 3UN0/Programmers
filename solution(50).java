class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer;
        int col = arr2[0].length;
        int row = arr1.length;
        
        answer = new int[row][col];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int k=0;k<arr1[0].length;k++){
                    answer[i][j] += arr1[i][k]*arr2[k][j];
                    
                }
                
            }
        }
        
        
        return answer;
    }
}
