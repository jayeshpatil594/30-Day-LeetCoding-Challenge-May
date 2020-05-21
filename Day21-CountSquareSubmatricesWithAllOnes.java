class Solution {
    public int countSquares(int[][] matrix) {
      // Time : O(n * m) Space : O(1)
        int res = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 || j == 0){
                    res += matrix[i][j];
                }
                else if(matrix[i][j] == 1){
                    matrix[i][j] = 1 + Math.min(matrix[i -1][j -1], Math.min(matrix[i -1][j], matrix[i][j -1]));
                    res += matrix[i][j];
                }
            }
        }
        return res;
    }
}
