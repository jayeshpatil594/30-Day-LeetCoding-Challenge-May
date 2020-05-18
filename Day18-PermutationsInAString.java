class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //sliding window problem
        // Time : O(n) Space: O(p)
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int end = 0;
        int count = map.size();
        while(end < s2.length()){
            char c = s2.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0)
                    count--;
            }
            end++;
            while(count == 0){
                char ch = s2.charAt(start);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) > 0)
                        count++;
                }
                if(end - start == s1.length()){
                    return true;
                }
                start++;
            }
        }
        return false;
    }
}
