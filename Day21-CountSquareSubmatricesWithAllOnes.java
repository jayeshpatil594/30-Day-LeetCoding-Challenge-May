class Solution {
    public int countSquares(int[][] matrix) {
       //If changing of matrix is allowed.
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
        //If changing matrix is not allowed.
        //Time : O(n * m) Space: O(n * m)
        /*
         if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0];
            res += matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = matrix[0][j];
            res += matrix[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int min = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                    dp[i][j] = 1 + min;
                    if (dp[i][j] >= 1) {
                        res += (dp[i][j]);
                    }
                }
                else dp[i][j] = 0;
            }
        }
        return res;
        */
    }
}
