class Solution {
    public int majorityElement(int[] nums) {
    //Method 1: Time: O(n) Space: O(n) (n is atmost n/2 since the majority element always exist in the array)
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length ; i++){
            
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            
            if(map.get(nums[i]) > nums.length/2){
                res = nums[i];
                break;
            }
        }
   
        return res;
        /*
        Method 2: Time: O(nlogn) Space: O(1)
        class Solution {
            public int majorityElement(int[] nums) {
                Arrays.sort(nums);
                return nums[nums.length/2];
            }
        }
        */
        
        /* Method 3:
        Boyer-Moore Voting Algorithm: Time: O(n) Space: O(1)
        Intuition:1) count the instances of a majority number as +1.
                  2) count the instances of a minority numbder as -1.
                  3) maintain these counts and once this count becomes zero forget everything upto the current index.
                  4) Eventually a window(or a suffix) will be found for which the count is not zero.
                  
                  class Solution {
                      public int majorityElement(int[] nums) {
                          int count = 0;
                          Integer candidate = null;

                          for (int num : nums) {
                              if (count == 0) {
                                  candidate = num;
                              }
                              count += (num == candidate) ? 1 : -1;
                          }

                          return candidate;
                      }
                  }
        */
    }
}
