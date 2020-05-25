class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        /*
        //Method 1 : DP 
        // Time: O(n ^ 2) Space: O(n ^ 2)
        int[][] dp = new int[A.length + 1][B.length + 1];
        
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= B.length; j++){
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i -1][j]);
                }
            }
        }
        return dp[A.length][B.length];
        */
        
        //Method 2: DP with space optimization
        // Time: O(n ^ 2) Space: O(n)
        int m = A.length, n = B.length; 
        
        int dp[][] = new int[2][n+1]; 

        // Binary index, used to index  
        // current row and previous row. 
        int binaryIndex=0; 

        for (int i = 0; i <= m; i++) 
        {        
            // Compute current binary index 
            // 1 if i is odd number else 0
            binaryIndex = i & 1; 

            for (int j = 0; j <= n; j++) 
            { 
                if (i == 0 || j == 0) 
                    dp[binaryIndex][j] = 0; 

                else if (A[i - 1] ==  B[j - 1]) 
                    dp[binaryIndex][j] = dp[1 - binaryIndex][j - 1] + 1; 

                else
                    dp[binaryIndex][j] = Math.max(dp[1 - binaryIndex][j],  dp[binaryIndex][j - 1]); 
            } 
        } 
        return dp[binaryIndex][n]; 
    }
}
