class Solution {
    public int[] countBits(int num) {
        // Time: O(n) Space: O(n)
        int[] res = new int[num + 1];
        res[0] = 0;
        
        for(int i = 1; i <= num; i++){
            if(i % 2 == 0){
                //if i is even then last bit is zero
                //i :      101010101010
                //i >> 1: 10101010101
                //ans for res[i] is same as res[i >> 1]
                res[i] = res[i >> 1];
            }
            else{
                //if i is odd then the last bit is one
                //so answer for res[i] is same as res[i-1] which is the prev num(i.e a even number) + 1
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}
