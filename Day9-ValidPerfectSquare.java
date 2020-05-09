class Solution {
    public boolean isPerfectSquare(int num) {
        //Binary Search
        //Time: O(logn) Space: O(1)
        if(num == 1){
            return true;
        }
        int l = 1;
        int r = num/2;
        
            while(l <= r){
                int mid = l + (r - l) / 2;
                
                if(mid * mid == num){
                    return true;
                } 
                else if(mid > num / mid){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
        }
    return false;
    
    //Method 2: Time: O(sqrt(n)) Space:O(1)
    // eg : 4 = 1 + 3
    //      9 = 1 + 3 + 5 , so 1 + 3 +...2n + 1 = n*n
    /*
        public boolean isPerfectSquare(int num) {
         int i = 1;
         while (num > 0) {
             num -= i;
             i += 2;
         }
         return num == 0;
         }
    */
    }
}
