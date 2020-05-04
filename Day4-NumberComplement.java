class Solution {
    public int findComplement(int num) {
    //Time : O(logn) Space: O(1)
        //method 1:
        //corner case
        if(num == 0){
            return 1;
        }
        int res = 0;
        int x = 1;
        while(num != 0){
            if(num%2 == 0){
                res += x;
            }
            num /= 2;
            x *= 2;
        }
        return res;
        
        /*
        //method 2:
        // num + bitwisecomplement(num) = x (which is 111..111 )
        // so bitwisecomplement(num) = x - num
        int x = 1;
        //find the number x just greater than the num.
        while(N > x){
        //for eg to get a num like 7 which has all one in binary, we say (x = 3*2 + 1)
          x = x*2 + 1;
        }
        return x - num;
        */
        //method 3: Similar to 2 but using xor
        /* num ^ bitwisecomplement(num) = x (which is 111..111 )
         so bitwisecomplement(num) = num ^ x */
    }
}
