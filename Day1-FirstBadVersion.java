/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

Time : O(logn)
Space : O(1)

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while(l < r){
	/*
	  to take care of overflow use mid = l + (r-l)/2 instead of mid = (l+r)/2
	  for ex : l = 2147483647
	  	   r = 2147483647
	           mid using (l + r)/2 = -1
	           mid using l + (r - l)/2 = 2147483647
	*/
            int mid = l + (r - l) / 2;
            if(isBadVersion(mid) == true){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}