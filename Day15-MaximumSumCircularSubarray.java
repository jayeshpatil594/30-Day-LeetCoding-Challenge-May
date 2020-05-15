class Solution {
    public int maxSubarraySumCircular(int[] A) {
        //Time: O(N) Space: O(1)
        //kadane's algorithm 
        int max_so_far = 0;
        int max_sum = Integer.MIN_VALUE;
        int min_so_far = 0;
        int min_sum = Integer.MAX_VALUE;
        int arraySum = 0;
        for(int i =0; i < A.length; i++){
            arraySum += A[i];
            max_so_far = Math.max(A[i], max_so_far + A[i]);
            max_sum = Math.max(max_sum, max_so_far);
        }
        for(int i =0; i < A.length; i++){
            min_so_far = Math.min(A[i], min_so_far + A[i]);
            min_sum = Math.min(min_sum, min_so_far);
        }
        return max_sum > 0 ? Math.max(max_sum, arraySum - min_sum) : max_sum;
    }
}
