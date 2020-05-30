class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //Method 1 :
        //MaxHeap
        //Time : O(n) + O(nlogk) = O(nlogk) if k is small, 
        // where O(n) (amortized ,this is O(nlogn) in the worst case) is required to build the heap
        //O(nlogk) is required for extraction.
        //Space: O(k)
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((p1,p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        
        for(int[] point : points){
            maxHeap.add(point);
            if(maxHeap.size() > K){
                maxHeap.poll();
            }
        }
        int[][] res = new int[K][2];
        while(K != 0){
            K--;
            res[K] = maxHeap.poll();
        }
        return res;
        //RT : 30ms
        
        
        
        /* Method 2:
        //MinHeap
        //Time: O(n) + O(klogn)
        //Space: O(k)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((p1,p2) -> (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]));
        for(int[] point : points){
            minHeap.add(point);
        }
        int i = 0;
        int[][] res = new int[K][2];
        while(i < K){
            res[i++] = minHeap.poll();
        }
        return res;
        //RT : 21ms
        */
        
        
        /* Method : 3
        //Sorting
        // Time: O(nlogn)
        Arrays.sort(points, (p1, p2) -> (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]));
        return Arrays.copyOfRange(points, 0, K);
        //RT : 23ms
        */
    }
}
