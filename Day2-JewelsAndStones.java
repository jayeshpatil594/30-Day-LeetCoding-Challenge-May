class Solution {
    public int numJewelsInStones(String J, String S) {
       
        //Solution 1: Time = O(J*S)  Space = O(1)
        
        /* 
       int count = 0;
        for(int i = 0; i < S.length() ; i++){
            for(int j = 0; j < J.length() ; j++){
                if(S.charAt(i) == (J.charAt(j))){
                    count++;
                }  
            }         
        }
        return count;
        */
        
        //Solution 2: Time = O(J+S)  Space = O(J)
        
        int count = 0;
        Set<Character> set = new HashSet<>();
        
        for(char c : J.toCharArray()){
            set.add(c);
        }
        for(char c : S.toCharArray()){
            if(set.contains(c)){
                count++;
            }
        }
        return count;
    }
}