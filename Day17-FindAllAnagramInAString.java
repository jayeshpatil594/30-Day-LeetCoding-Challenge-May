class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //sliding window problem
        // Time : O(n) Space: O(p)
        List<Integer> res = new ArrayList<>();
        if(s.length() == 0 || s == null || p.length() > s.length()){
            return res;
        }
        Map<Character, Integer> charFreq = new HashMap<>();
        //Build an HashMap containing the count of each char in the p string
        for(char c : p.toCharArray()){
            charFreq.put(c, charFreq.getOrDefault(c,0) + 1);
        }
        
        int start = 0;
        int end = 0;
        int count = charFreq.size();
        
        while(end < s.length()){
            char c = s.charAt(end);
            //Decrement the counter of each char for each char you insert in the sliding window
            if(charFreq.containsKey(c)){
                charFreq.put(c, charFreq.get(c) - 1);
                if(charFreq.get(c) == 0){
                    count--;
                }
            }
            end++;
            
            while(count == 0){
                char ch = s.charAt(start);
                //Increment the counter of each char for each char you remove from the sliding window
                if(charFreq.containsKey(ch)){
                    charFreq.put(ch, charFreq.get(ch) +1);
                    if(charFreq.get(ch) > 0){
                        count++;
                    }
                }
                 if(end - start == p.length()){
                        res.add(start);
                    }
                start++;
            }         
        }
        return res;
    }
}
