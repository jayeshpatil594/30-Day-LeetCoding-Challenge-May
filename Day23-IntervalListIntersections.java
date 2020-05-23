class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        //Time : O(A + B) Space: O(A + B)
        
        List<int[]> res = new ArrayList<>();
        //two pointers
        int i = 0;
        int j = 0;
        
        while(i < A.length && j < B.length){
            //starting point of interval
            int start = Math.max(A[i][0], B[j][0]);
            //end point of interval
            int end = Math.min(A[i][1], B[j][1]);
            
            if(start <= end){
                res.add(new int[]{start, end});
            }
            // move the pointer for the smaller end value
            if(A[i][1] < B[j][1]){
                i++;
            }
            else{
                j++;
            }
        }
        //return res.toArray(new int[res.size()][]);
        return res.toArray(new int[0][]);
    }
}
