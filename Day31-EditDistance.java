class Solution {
    public int minDistance(String word1, String word2) {
        //space optimised 
        //Time : O(m * n) Space: O(n)
        Integer[][] dp = new Integer[2][word2.length()+1];
        
        for(int i = 0; i<= word2.length() ; i++){
            dp[0][i] = i;
        }
        
        for(int i = 1; i<= word1.length(); i++){
            for(int j = 0; j <= word2.length() ; j++){
// if first string is empty then we have to perform add character operation to get second string 
                if(j==0){
                    dp[i%2][j] = i;
                }
                else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i%2][j] = dp[(i-1)%2][j-1];
                }
                else{
                    dp[i%2][j] = 1 + Math.min(dp[(i-1)%2][j], Math.min(dp[i%2][j-1], dp[(i-1)%2][j-1]));
                }
            }
        }
       return dp[word1.length()%2][word2.length()];  
        
        
        
        /*
        //Time:O(m * n) Space: O(m * n)
        Integer[][] dp = new Integer[word1.length()+1][word2.length()+1];
        for(int i = 0 ; i< dp[0].length ; i++){
            dp[0][i] = i;
        }
        for(int j = 0; j<dp.length ; j++){
            dp[j][0] = j;
        }
        
        for(int i = 1; i<= word1.length(); i++){
            for(int j = 1; j <= word2.length() ; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    //if both characters are same upperleft diagnal value
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                //if both characters are diff then min of (upperleft diagonal, upper , sideleft)
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];*/
    }
}
