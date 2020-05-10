class Solution {
    public int findJudge(int N, int[][] trust) {
    //Time: O(n) Space: O(n)
        int[] trusts = new int[N + 1];
        int[] trustedBy = new int[N + 1];
        
        for(int i = 0; i < trust.length; i++){
            trustedBy[trust[i][1]]++;
            trusts[trust[i][0]]++;
        }
        
        for(int i = 1; i <= N; i++){
          //A judge trusts nobody and is trusted by everybody
            if(trusts[i] == 0 && trustedBy[i] == N-1){
                return i;
            }   
        }
        return -1;
    }
}
