class Solution {
    public int singleNonDuplicate(int[] nums) {
        //binary search Time: O(logn) Space: O(1)
        int l = 0;
        int r = nums.length - 1;
        
        while(l < r){
            int mid = (l + r) / 2;
            // mid ^ 1 flips the last bit of mid, i.e 1 => 0 and 0 => 1
            //so basically if mid is even => add 1 and if mid is odd => subtract 1
            if(nums[mid] == nums[mid ^ 1]){ // same as below commented code
                l = mid + 1;
            }
           /* if(mid % 2 == 0 && nums[mid] == nums[mid + 1]){
                l = mid + 1;
            }
            else if(mid % 2 == 1 && nums[mid] == nums[mid - 1]){
                l = mid + 1;
            } */
            else{
                r = mid ;
            }
        }
        return nums[l];
       /* 
       Time: O(n) Space : O(1)
       int res = nums[0];
        for(int i =1;i < nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
        */
    }
}
