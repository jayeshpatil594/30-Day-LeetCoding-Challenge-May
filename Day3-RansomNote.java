class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
	//using freq array
        int[] charsFrequency = new int[26];
        for(char c : magazine.toCharArray()){
            charsFrequency[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            if(--charsFrequency[c - 'a'] < 0){
                return false;
            }
        }
        return true;
        
        /*
	//Using HashMap
        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c : ransomNote.toCharArray()){
            if((map.getOrDefault(c, 0)-1) < 0){
                return false;
            }
            map.put(c, map.getOrDefault(c, 0)-1);
        }
        return true;
        */
    }
}